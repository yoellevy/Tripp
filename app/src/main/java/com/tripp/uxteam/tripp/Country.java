package com.tripp.uxteam.tripp;

import java.util.ArrayList;

public class Country {

    private ArrayList<City> cities;
    private String countryName;

    Country(String cityName){
        this.countryName = cityName;
    }

    void addCity(City city){
        cities.add(city);
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public String getCountryName() {
        return countryName;
    }
}
