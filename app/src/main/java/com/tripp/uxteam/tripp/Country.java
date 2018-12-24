package com.tripp.uxteam.tripp;

import java.util.ArrayList;

public class Country {

    private ArrayList<City> cities;
    private String countryName;
    private Continent continent;

    Country(String countryName, Continent continent){
        this.cities = new ArrayList<City>();
        this.countryName = countryName;
        this.continent = continent;
        continent.addCountry(this);
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

    public Continent getContinent() {
        return continent;
    }
}
