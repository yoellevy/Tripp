package com.tripp.uxteam.tripp;

// This small class is meant to be used to menage and create attractions for the app
public class Attraction {

    static long id_index = 1;
    private long id;
    private String name;
    private String googleMapsUrl;
    private String tripAdvisorUrl;
    private String shortDescription;
    private String imgUrl;

    // we set some tags that an attraction can have. a station can have several tags.
    private TAGS[] tags;

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


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public String getTripAdvisorUrl() {
        return tripAdvisorUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
