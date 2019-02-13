package com.tripp.uxteam.tripp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Trip {
    private String name;
    private ArrayList<Attraction> attractions;
    private double[] tripCharacteristicVec;

    Trip(String name, double[] charVec) {
        this.name = name;
        attractions = new ArrayList<>();
        this.tripCharacteristicVec = charVec;
    }

    void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    String getName() {
        return name;
    }

    double[] getTripCharacteristicVec() {
        return this.tripCharacteristicVec;
    }
}
