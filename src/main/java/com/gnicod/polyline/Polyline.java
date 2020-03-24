package com.gnicod.polyline;

import java.util.ArrayList;

public class Polyline {

    public static ArrayList<Point> decode(String str, Float precision) {
        ArrayList<Point> coordinates = new ArrayList<Point>();
        int index = 0;
        int lat = 0, lng = 0;

        while (index < str.length()) {
            int b, shift = 0, result = 0;
            do {
                b = str.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = str.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            Point p = new Point((double) lat / precision, (double) lng / precision);
            coordinates.add(p);
        }
        return coordinates;
    }
}


