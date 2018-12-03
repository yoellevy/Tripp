package com.tripp.uxteam.tripp;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.tripp.uxteam.tripp.TAGS.Art;
import static com.tripp.uxteam.tripp.TAGS.Beaches;
import static com.tripp.uxteam.tripp.TAGS.Concerts;
import static com.tripp.uxteam.tripp.TAGS.Extreme;
import static com.tripp.uxteam.tripp.TAGS.Festivals;
import static com.tripp.uxteam.tripp.TAGS.Food;
import static com.tripp.uxteam.tripp.TAGS.Hiking;
import static com.tripp.uxteam.tripp.TAGS.Parties;
import static com.tripp.uxteam.tripp.TAGS.Romantic;
import static com.tripp.uxteam.tripp.TAGS.SiteSeeing;
import static com.tripp.uxteam.tripp.TAGS.Theater;

public class MockAttractions {

    private List<Attraction> attractions = new ArrayList<Attraction>();

    MockAttractions() {
        Continent europe = new Continent("Europe");
        TAGS[] tags1 = {Romantic, SiteSeeing, Food, Art, Festivals};
        City prague = new City("Prague", new Country("Czech Republic", europe));


        attractions.add(new Attraction("Karlov Most",
                "https://www.google.com/maps/place/Charles+Bridge/@50.0864771,14.4092479,17z/data=!3m1!4b1!4m5!3m4!1s0x470b94e5e58eb59f:0x75209738d1d3b126!8m2!3d50.0864771!4d14.4114366",
                "https://www.tripadvisor.com/Attraction_Review-g274707-d275157-Reviews-Karluv_most-Prague_Bohemia.html",
                "Karlov Most - the most beautiful bridge in Czech Republic",
                "https://www.prague.eu/object/93/karluv-most-motiv.jpg",
                prague,
                tags1));

        TAGS[] tags2 = {Romantic, SiteSeeing, Food, Art, Festivals, Concerts};
        attractions.add(new Attraction("Staroměstská Radnice",
                "https://www.google.com/maps/place/Old+Town+Hall/@50.0870344,14.4183086,17z/data=!3m1!4b1!4m5!3m4!1s0x470b94e930b83655:0xb03c01703d568d5!8m2!3d50.0870471!4d14.4205023",
                "https://www.tripadvisor.com/ShowUserReviews-g274707-d275152-r122659339-Old_Town_Hall_with_Astronomical_Clock-Prague_Bohemia.html",
                "Staroměstská Radnice - the Old Town Hall",
                "https://c1.staticflickr.com/1/908/27037566767_c74b3b9b03_b.jpg",
                prague,
                tags2));

        TAGS[] tags3 = {Romantic, SiteSeeing, Art, Concerts};
        attractions.add(new Attraction("Pražský Hrad",
                "https://www.google.com/maps/place/Prague+Castle/@50.0910966,14.3994278,17z/data=!3m1!4b1!4m5!3m4!1s0x470b951e6c24b7c3:0x2acf3c88af12259f!8m2!3d50.0910966!4d14.4016165",
                "https://www.tripadvisor.co.za/ShowUserReviews-g274707-d275235-r569395822-Prague_Castle-Prague_Bohemia.html",
                "pražský hrad - the Prague castle",
                "https://www.hrad.cz/file/edee/public/2015/09/svatyvit-20150923-141241.jpg",
                prague,
                tags3));



        TAGS[] tags4 = {Romantic, SiteSeeing, Food, Art, Festivals, Concerts};
        City paris = new City("Paris", new Country("France", europe));

        attractions.add(new Attraction("Arc de Triomphe",
                "https://www.google.com/maps?q=Arc+de+Triomphe&client=firefox-b-ab&biw=1920&bih=929&um=1&ie=UTF-8&sa=X&ved=0ahUKEwjEoaiM74PfAhUKJ1AKHccMDagQ_AUICygC",
                "https://www.tripadvisor.com/AttractionProductReview-g187147-d12152818-Skip_the_Line_Arc_de_Triomphe_Including_Terrace_Access-Paris_Ile_de_France.html",
                "Arc de Triopmphe - a centeral stop in paris",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxA3W0R7k345KVgDTdP9m55DMRvgfq4WMeFrTaOUJq0_FDNY6D",
                paris,
                tags4));

        TAGS[] tags5 = {Romantic, SiteSeeing, Food, Art, Festivals, Concerts};

        attractions.add(new Attraction("Eiffel Tower",
                "https://www.google.com/maps?q=Eiffel+Tower&oe=utf-8&client=firefox-b-ab&um=1&ie=UTF-8&sa=X&ved=0ahUKEwjSiJXj8IPfAhUJL1AKHZggBV0Q_AUIDygC",
                "https://www.tripadvisor.com/AttractionProductReview-g187147-d11472816-Eiffel_Tower_Priority_Access_Ticket_with_Host-Paris_Ile_de_France.html",
                "The Eiffel Tower doesn't need a description :)",
                "https://www.discoverwalks.com/blog/wp-content/uploads/2017/06/around-the-eiffel-tower.jpg",
                paris,
                tags5));

        TAGS[] tags6 = {Romantic, SiteSeeing, Food, Art, Festivals, Concerts};

        attractions.add(new Attraction("Galeries Lafayette Paris Haussmann",
                "https://www.google.com/maps?q=Galeries+Lafayette+Paris+Haussmann&oe=utf-8&client=firefox-b-ab&um=1&ie=UTF-8&sa=X&ved=0ahUKEwjd0erM8YPfAhXPJlAKHeieBxMQ_AUIDygC",
                "https://www.tripadvisor.com/Attraction_Review-g187147-d189193-Reviews-Galeries_Lafayette_Paris_Haussmann-Paris_Ile_de_France.html",
                "Galeries Lafayette Paris Haussmann - THE ULTIMATE SHOPPING DESTINATION!",
                "https://media-cdn.tripadvisor.com/media/photo-s/0c/aa/fb/74/underneath-the-glass.jpg",
                paris,
                tags6));

    }
}
