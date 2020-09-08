package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class DataManager {

    private Set<City> cityList;
    private Set<Person> personSet;

    public DataManager() throws Exception {
        this.cityList = new HashSet<>();
        this.personSet = new HashSet<>();
    }

    public void loadCityData() throws Exception {

        // Load file
        URL resource = getClass().getClassLoader().getResource("worldcities.csv");


        Scanner scanner = new Scanner(new File(resource.toURI()));

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
                City city = new City(values[0]);
                city.setLongitude(Double.parseDouble(values[3]));
                city.setLatitude(Double.parseDouble(values[2]));

                cityList.add(city);
            } catch (Exception ignored) {
            }
        }
    }

    public void loadPersonData() {

        JSONArray personList = new JSONArray(this.getDataFromURL("https://bpdts-test-app.herokuapp.com/users"));

        for (int i = 0; i < personList.length(); i++) {
            JSONObject jsonObject = (JSONObject) personList.get(i);
            int id = jsonObject.getInt("id");
            double latitude = jsonObject.getDouble("latitude");
            double longitude = jsonObject.getDouble("longitude");

            Person person = new Person(id);
            person.setLatitude(latitude);
            person.setLongitude(longitude);

            personSet.add(person);
        }

    }

    public Person getPersonByID(int id) throws Exception {
        for (Person person : this.personSet) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new Exception("Person not found exception");
    }

    public City getCityByName(String cityName) throws Exception {
        for (City city : this.cityList) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        throw new Exception("City not found exception");
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
}
