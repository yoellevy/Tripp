package com.tripp.uxteam.tripp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Trip {
    private String name;
    private ArrayList<Attraction> attractions;

    Trip(String name) {
        this.name = name;
        attractions = new ArrayList<>();
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
        return new double[]{0, 0, 0, 0};
    }
}
