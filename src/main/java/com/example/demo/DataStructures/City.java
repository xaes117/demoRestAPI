package com.example.demo.DataStructures;

import com.example.demo.Lib.MathLib;

public class City {

    private String name;
    private double longitude;
    private double latitude;

    public City(String name) {
        this.name = name;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
