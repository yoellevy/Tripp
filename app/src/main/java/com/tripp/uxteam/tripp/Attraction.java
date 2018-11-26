package com.tripp.uxteam.tripp;

public class Attraction {
    static long id_index = 1;
    long id;
    String name;
    String googleMapsUrl;
    String tripAdvisorUrl;
    String shortDescription;
    String imgUrl;
    public enum TAGS {Hiking, Romantic, Beaches, Theater, Parties, SiteSeeing, Food, Extreme, Art}
    TAGS[] tags;

    Attraction(String name,
               String googleMapsUrl,
               String tripAdvisorUrl,
               String shortDescription,
               String imgUrl,
               TAGS[] tags){
        id_index += 1;
        this.id = id_index;
        this.name = name;
        this.googleMapsUrl = googleMapsUrl;
        this.tripAdvisorUrl = tripAdvisorUrl;
        this.shortDescription = shortDescription;
        this.imgUrl = imgUrl;
        this.tags = tags;
    }
}
