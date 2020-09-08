package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

public class DataManager {

    // Count unique instances in a JSON array
    public int uniqueInstances(JSONArray array) {

        // Use a set to ensure all values are unique
        Set<Integer> set = new HashSet<>();

        // Iterate through array
        for (int i = 0; i < array.length(); i++) {

            // Add by ID
            JSONObject js = (JSONObject) array.get(i);
            set.add(js.getInt("id"));
        }

        return set.size();

    }

    public String GetDataFromURL(String url) {

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

}
