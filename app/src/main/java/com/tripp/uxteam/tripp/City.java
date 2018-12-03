package com.tripp.uxteam.tripp;

import java.util.ArrayList;

class City {

    private Country country;
    private String cityName;
    private ArrayList<Attraction> attractions;

    City(String cityName, Country country){
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
