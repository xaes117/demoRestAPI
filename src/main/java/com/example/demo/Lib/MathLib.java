package com.example.demo.Lib;

public class MathLib {

    public static double distance(double lon1, double lat1, double lon2, double lat2) {

        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }

        double theta = lon1 - lon2;

        // Use Haversine formula
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));

        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515 * 0.8684;
        dist = Math.round(dist);

        return dist;

    }
}
