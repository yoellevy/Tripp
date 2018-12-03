package com.tripp.uxteam.tripp;

import java.util.ArrayList;

class Continent {

    private ArrayList<Country> countries;
    private String continentName;

    Continent(String cityName){
        this.countries = new ArrayList<Country>();
        this.continentName = cityName;
    }

    void addCountry(Country country){
        this.countries.add(country);
    }

    ArrayList<Country> getAllCountries(){
        return this.countries;
    }

    public String getContinentName() {
        return continentName;
    }
}
