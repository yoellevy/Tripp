package com.tripp.uxteam.tripp;

// This small class is meant to be used to menage and create attractionsNames for the app
public class Attraction {

    private static long id_index = 1;
    private long id;
    private String name;
    private String assetName;
    private String googleMapsUrl;
    private String tripAdvisorUrl;
    private String shortDescription;

    // we set some tags that an attraction can have. a station can have several tags.
    // same as user characteristic vector
    private double[] attractionCharacteristicVec;

    Attraction(String name,
               String assetName,
               String googleMapsUrl,
               String tripAdvisorUrl,
               String shortDescription,
               double[] charVec) {
        this.name = name;
        this.id = id_index;
        this.assetName = assetName;
        this.googleMapsUrl = googleMapsUrl;
        this.tripAdvisorUrl = tripAdvisorUrl;
        this.shortDescription = shortDescription;
        this.attractionCharacteristicVec = charVec;
        id_index += 1;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAssetName() {
        return this.assetName;
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

    public String getImgName() {
        return "";
    }

    public double[] getAttractionCharacteristicVec() {
        return attractionCharacteristicVec;
    }
}
