package com.tripp.uxteam.tripp;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TripPicker {

    private double similarityThreshold = 0.5;

    private LinkedList<User> users;

    public TripPicker(LinkedList<User> systemUsers) {
        users = systemUsers;
    }

    public Trip getTrip(User logedInUser, double[] desiredTrip){
        sortUsers(logedInUser);

        if(desiredTrip[0] == 0.25 && desiredTrip[1] == 0.25 && desiredTrip[2] == 0.25 && desiredTrip[3] == 0.25)
            return users.get(0).getTrips().get(0);

        for (int i = 0; i < users.size(); i++) {
            User chosenUser = users.get(i);
            System.out.println("Current user in index: " + i);
            for (Trip trip: chosenUser.getTrips()) {
                if (calculateDistance(desiredTrip, trip) < similarityThreshold) // good enough trip
                {
                    System.out.println("Found good enough trip: " + trip.getName());
                    return trip;
                }
            }
        }
        // recursive call to function with a larger threshold:
        similarityThreshold += 0.2;
        return getTrip(logedInUser, desiredTrip);
    }

    private double calculateDistance(User user1, User user2){
        double[] distanceVector = new double[]{0, 0, 0, 0};
        double[] char1 = user1.getCharacteristicVec();
        double[] char2 = user2.getCharacteristicVec();
        // calculate distances vector:
        for (int i = 0; i < char1.length; i++) {
            distanceVector[i] = Math.abs(char2[i] - char1[i]);
        }
        double sum = 0;
        for (int i = 0; i < char1.length; i++) {
            sum += distanceVector[i];
        }
        return sum; // return the sum of distances (range: 0-1)
    }

    private double calculateDistance(double[] desiredTrip, Trip foundTrip){
        double[] distanceVector = new double[]{0, 0, 0, 0};
        double[] tripCharacteristics = foundTrip.getTripCharacteristicVec();
        // calculate distances vector:
        for (int i = 0; i < tripCharacteristics.length; i++) {
            distanceVector[i] = Math.abs(desiredTrip[i] - tripCharacteristics[i]);
        }
        double sum = 0;
        for (int i = 0; i < tripCharacteristics.length; i++) {
            sum += distanceVector[i];
        }
        return sum; // return the sum of distances (range: 0-1)
    }

    private void sortUsers(User logedInUser){
        Collections.sort(users, new Comparator<User>(){
            @Override
            public int compare(User u1, User u2) {
                return Double.compare(calculateDistance(Globals.currentSessionUser, u1),
                        calculateDistance(Globals.currentSessionUser, u2));
            }
        });
    }
}