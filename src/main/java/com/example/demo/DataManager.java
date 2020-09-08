package com.example.demo;

import com.example.demo.DataStructures.City;
import com.example.demo.DataStructures.Person;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class DataManager {

    private Set<City> cityList;
    private Set<Person> personSet;

    public DataManager() throws Exception {
        this.cityList = new HashSet<>();
        this.personSet = new HashSet<>();

        this.loadCityData();
        this.loadPersonData();
    }

    public void loadCityData() throws Exception {

        // Load file
        URL resource = getClass().getClassLoader().getResource("worldcities.csv");
        Scanner scanner = new Scanner(new File(resource.toURI()));

        // Read file
        while (scanner.hasNextLine()) {

            String[] values = scanner.nextLine().split(",");

                /*

                Values array will look like this

                0 = "city"
                1 = "city_ascii"
                2 = "lat"
                3 = "lng"
                4 = "country"
                5 = "iso2"
                6 = "iso3"
                7 = "admin_name"
                8 = "capital"
                9 = "population"
                10 = "id"
                 */

            try {

                // Create city
                City city = new City(values[0]);

                // Set longitude, 3 = "lng"
                city.setLongitude(Double.parseDouble(values[3]));

                // Set latitude, 2 = "lat"
                city.setLatitude(Double.parseDouble(values[2]));

                // Add to list
                cityList.add(city);

            } catch (Exception ignored) {
            }
        }
    }

    public void loadPersonData() {

        // Use overloaded function unless you have specific url in mind
        JSONArray personList = new JSONArray(this.getDataFromURL());

        for (int i = 0; i < personList.length(); i++) {

            // Assign variables to attributes
            JSONObject jsonObject = (JSONObject) personList.get(i);
            int id = jsonObject.getInt("id");
            double latitude = jsonObject.getDouble("latitude");
            double longitude = jsonObject.getDouble("longitude");

            // Create Person object
            Person person = new Person(id);
            person.setLatitude(latitude);
            person.setLongitude(longitude);

            // Add to list
            personSet.add(person);
        }

    }

    public int populationByCity(String cityName) {

        // Get data for city
        String data = this.getDataFromURL("https://bpdts-test-app.herokuapp.com/city/" + cityName + "/users");

        // Convert to JSON array
        JSONArray array = new JSONArray(data);

        // Assumes everything in the array is unique
        // Consider checking for duplicates
        return array.length();

    }

    public Person getPersonByID(int id) throws Exception {

        // Iterate through personSet until you find a matching ID
        for (Person person : this.personSet) {
            if (person.getId() == id) {
                return person;
            }
        }

        // Throw exception if no id found
        throw new Exception("Person not found exception");
    }

    public City getCityByName(String cityName) throws Exception {

        // Iterate through cityList until you find a match by city name
        for (City city : this.cityList) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }

        // Throw exception if no city found
        throw new Exception("City not found exception");
    }

    private String getDataFromURL() {
        return getDataFromURL("https://bpdts-test-app.herokuapp.com/users");
    }

    private String getDataFromURL(String url) {

        StringBuilder outputString = new StringBuilder();

        try {

            URL urlString = new URL(url);
            URLConnection yc = urlString.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                outputString.append(inputLine);
            }

            in.close();

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputString.toString();

    }

    public Set<City> getCityList() {
        return this.cityList;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }
}
