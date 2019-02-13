package com.tripp.uxteam.tripp;

import java.util.ArrayList;
import java.util.LinkedList;

public class User {
    private double[] characteristicVec = new double[]{0, 0, 0, 0};
    private ArrayList<Trip> trips;

    User(double[] charVec) {
        characteristicVec = charVec;
        trips = new ArrayList<>();
    }

    void addTrip(Trip trip) {
        trips.add(trip);
    }

    ArrayList<Trip> getTrips() {
        return trips;
    }

    public double[] getCharacteristicVec() {
        return characteristicVec;
    }

    public void setCharacteristicVec(double[] charVec) {
        this.characteristicVec = charVec;
    }
}
