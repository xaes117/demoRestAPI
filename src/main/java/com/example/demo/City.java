package com.example.demo;

import com.example.demo.Lib.MathLib;

public class City {

    private String name;
    private double longitude;
    private double latitude;

    public City(String name) {
        this.name = name;
    }

    public double distanceFromCity(double lon, double lat) {
        return MathLib.distance(this.longitude, this.latitude, lon, lat);
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
