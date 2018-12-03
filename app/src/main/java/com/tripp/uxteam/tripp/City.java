package com.tripp.uxteam.tripp;

import java.util.ArrayList;

class City {

    private ArrayList<Attraction> attractions;
    private String cityName;
    private Country country;

    City(String cityName, Country country){
        this.attractions = new ArrayList<>();
        this.cityName = cityName;
        this.country = country;
        country.addCity(this);
    }

    ArrayList<Attraction> getAllAttractions(){
        return this.attractions;
    }

    void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    public String getCityName() {
        return cityName;
    }

    public Country getCountry() {
        return country;
    }
}
