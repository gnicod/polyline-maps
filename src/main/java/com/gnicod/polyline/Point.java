package com.gnicod.polyline;

import java.io.Serializable;

public class Point implements Serializable {

    private final double lat;
    private final double lng;

    public Point(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "(" + lat + ", " + lng + ")";
    }

}
