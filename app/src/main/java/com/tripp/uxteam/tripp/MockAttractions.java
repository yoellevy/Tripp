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
import static com.tripp.uxteam.tripp.TAGS.Nature;
import static com.tripp.uxteam.tripp.TAGS.Parties;
import static com.tripp.uxteam.tripp.TAGS.Romantic;
import static com.tripp.uxteam.tripp.TAGS.Shopping;
import static com.tripp.uxteam.tripp.TAGS.SiteSeeing;
import static com.tripp.uxteam.tripp.TAGS.Theater;

public class MockAttractions {

    private List<Attraction> attractions = new ArrayList<Attraction>();

    MockAttractions() {
        Continent [] continents = {new Continent("Europe"), new Continent("Asia")};
        Continent europe = continents[0];

        City[] cities = {new City("Prague", new Country("Czech Republic", europe)),
                         new City("Paris", new Country("France", europe))};
        City prague = cities[0];
        City paris = cities[1];

        attractions.add(new Attraction("Karlov Most",
                "https://www.google.com/maps/place/Charles+Bridge/@50.0864771,14.4092479,17z/data=!3m1!4b1!4m5!3m4!1s0x470b94e5e58eb59f:0x75209738d1d3b126!8m2!3d50.0864771!4d14.4114366",
                "https://www.tripadvisor.com/Attraction_Review-g274707-d275157-Reviews-Karluv_most-Prague_Bohemia.html",
                "Karlov Most - the most beautiful bridge in Czech Republic",
                "https://www.prague.eu/object/93/karluv-most-motiv.jpg",
                prague,
                new TAGS[]{Romantic, SiteSeeing, Food, Art, Festivals}));

        attractions.add(new Attraction("Staroměstská Radnice",
                "https://www.google.com/maps/place/Old+Town+Hall/@50.0870344,14.4183086,17z/data=!3m1!4b1!4m5!3m4!1s0x470b94e930b83655:0xb03c01703d568d5!8m2!3d50.0870471!4d14.4205023",
                "https://www.tripadvisor.com/ShowUserReviews-g274707-d275152-r122659339-Old_Town_Hall_with_Astronomical_Clock-Prague_Bohemia.html",
                "Staroměstská Radnice - the Old Town Hall",
                "https://c1.staticflickr.com/1/908/27037566767_c74b3b9b03_b.jpg",
                prague,
                new TAGS[]{Romantic, SiteSeeing, Food, Art, Festivals, Concerts}));

        attractions.add(new Attraction("Pražský Hrad",
                "https://www.google.com/maps/place/Prague+Castle/@50.0910966,14.3994278,17z/data=!3m1!4b1!4m5!3m4!1s0x470b951e6c24b7c3:0x2acf3c88af12259f!8m2!3d50.0910966!4d14.4016165",
                "https://www.tripadvisor.co.za/ShowUserReviews-g274707-d275235-r569395822-Prague_Castle-Prague_Bohemia.html",
                "pražský hrad - the Prague castle",
                "https://www.hrad.cz/file/edee/public/2015/09/svatyvit-20150923-141241.jpg",
                prague,
                new TAGS[]{Romantic, SiteSeeing, Art, Concerts}));



        attractions.add(new Attraction("Arc de Triomphe",
                "https://www.google.com/maps?q=Arc+de+Triomphe&client=firefox-b-ab&biw=1920&bih=929&um=1&ie=UTF-8&sa=X&ved=0ahUKEwjEoaiM74PfAhUKJ1AKHccMDagQ_AUICygC",
                "https://www.tripadvisor.com/AttractionProductReview-g187147-d12152818-Skip_the_Line_Arc_de_Triomphe_Including_Terrace_Access-Paris_Ile_de_France.html",
                "Arc de Triopmphe - a centeral stop in paris",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxA3W0R7k345KVgDTdP9m55DMRvgfq4WMeFrTaOUJq0_FDNY6D",
                paris,
                new TAGS[]{SiteSeeing, Food}));


        attractions.add(new Attraction("Eiffel Tower",
                "https://www.google.com/maps?q=Eiffel+Tower&oe=utf-8&client=firefox-b-ab&um=1&ie=UTF-8&sa=X&ved=0ahUKEwjSiJXj8IPfAhUJL1AKHZggBV0Q_AUIDygC",
                "https://www.tripadvisor.com/AttractionProductReview-g187147-d11472816-Eiffel_Tower_Priority_Access_Ticket_with_Host-Paris_Ile_de_France.html",
                "The Eiffel Tower doesn't need a description :)",
                "https://www.discoverwalks.com/blog/wp-content/uploads/2017/06/around-the-eiffel-tower.jpg",
                paris,
                new TAGS[]{Romantic, SiteSeeing}));

        attractions.add(new Attraction("Galeries Lafayette Paris Haussmann",
                "https://www.google.com/maps?q=Galeries+Lafayette+Paris+Haussmann&oe=utf-8&client=firefox-b-ab&um=1&ie=UTF-8&sa=X&ved=0ahUKEwjd0erM8YPfAhXPJlAKHeieBxMQ_AUIDygC",
                "https://www.tripadvisor.com/Attraction_Review-g187147-d189193-Reviews-Galeries_Lafayette_Paris_Haussmann-Paris_Ile_de_France.html",
                "Galeries Lafayette Paris Haussmann - THE ULTIMATE SHOPPING DESTINATION!",
                "https://media-cdn.tripadvisor.com/media/photo-s/0c/aa/fb/74/underneath-the-glass.jpg",
                paris,
                new TAGS[]{Romantic, SiteSeeing, Art}));

        attractions.add(new Attraction("Les Catacombes",
                "https://goo.gl/maps/33BABDPAzwy",
                "https://www.tripadvisor.com/Attraction_Review-g187147-d189229-Reviews-The_Catacombs_of_Paris-Paris_Ile_de_France.html",
                "Les Catacombes - A Spooky experience!",
                "http://www.parigramme.com/datas/Double%20page/l/e/les-catacombes-de-paris/sl/les-catacombes-de-pa-590c72b977edb.jpg",
                paris,
                new TAGS[]{Romantic, SiteSeeing, Art}));

        attractions.add(new Attraction("Le Crazy Horse",
                "https://goo.gl/maps/r23FuL88Jyx",
                "https://www.tripadvisor.com/Attraction_Review-g187147-d211691-Reviews-Crazy_Horse-Paris_Ile_de_France.html?m=19905",
                "Femininity, creativity, daring ... Le Crazy Horse is the most iconic of all the Parisian cabarets !",
                "https://www.lecrazyhorseparis.com/wp-content/uploads/Crazy-Horse-le-film.jpg",
                paris,
                new TAGS[]{SiteSeeing, Art, Theater, Parties}));

        attractions.add(new Attraction("Fondation Louis Vuitton",
                "https://goo.gl/maps/LaBMrjLryu52",
                "https://www.tripadvisor.com/Attraction_Review-g187147-d7149635-Reviews-Fondation_Louis_Vuitton-Paris_Ile_de_France.html?m=19905",
                "Fondation Louis Vuitton’s ultra-sleek, ultra-slick modern art gallery opened in the Bois de Boulogne in 2014.",
                "https://www.fondationlouisvuitton.fr/content/flvinternet/en/la-fondation/la-fondation-d-entreprise-louis-vuitton/_jcr_content/content/columncontrol/leftG484/image.flvcrop.2048.5000.jpeg",
                paris,
                new TAGS[]{SiteSeeing, Art}));

        attractions.add(new Attraction("Marché d'Aligre",
                "https://goo.gl/maps/NE9h4GnwXFN2",
                "https://www.tripadvisor.com/Attraction_Review-g187147-d189197-Reviews-Marche_d_Aligre-Paris_Ile_de_France.html?m=19905",
                "One of the real veteran markets of Paris, Marché d’Aligre has survived revolutions, riots and waves of gentrification.",
                "https://afar-production.imgix.net/uploads/images/post_images/images/SL3yQfClV3/original_open-uri20131122-24477-1ubq3t6?1385115465?ixlib=rails-0.3.0&auto=format%2Ccompress&crop=entropy&fit=crop&h=719&q=80&w=954",
                paris,
                new TAGS[]{Romantic, SiteSeeing, Food, Shopping}));

        attractions.add(new Attraction("The Louvre",
                "https://goo.gl/maps/imgNimEUVnm",
                "https://www.tripadvisor.com/Attraction_Review-g187147-d188757-Reviews-Louvre_Museum-Paris_Ile_de_France.html?m=19905",
                "The world's largest museum is also its most visited, with an incredible 8.1 million visitors in 2017. It is a city within the city, a vast, multi-level maze of galleries, passageways, staircases and escalators.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Louvre_Museum_Wikimedia_Commons.jpg/800px-Louvre_Museum_Wikimedia_Commons.jpg",
                paris,
                new TAGS[]{Romantic, SiteSeeing, Art, Concerts}));

        attractions.add(new Attraction("Ménagerie du Jardin des Plantes",
                "https://goo.gl/maps/vPbAV8McUTq",
                "https://www.tripadvisor.com/Attraction_Review-g187147-d189240-Reviews-Menagerie_du_Jardin_des_Plantes-Paris_Ile_de_France.html?m=19905",
                "A small zoo located within the Jardin des Plantes.",
                "http://www.zoodujardindesplantes.fr/sites/menagerie/files/styles/bandeau_home/public/thumbnails/image/panthere_chine_cohen.jpg",
                paris,
                new TAGS[]{Romantic, SiteSeeing, Art, Nature}));

        attractions.add(new Attraction("France Miniature",
                "https://goo.gl/maps/BmPTT8n4hNq",
                "https://www.tripadvisor.com/Attraction_Review-g1940436-d245003-Reviews-France_Miniature-Elancourt_Yvelines_Ile_de_France.html?m=19905",
                "Come and admire the most beautiful Parisian monuments in one place, the most sumptuous palaces passed down from our Kings of France and discover the Gothic and Flemish architecture in the cities of Amiens, Lille and Arras.",
                "https://en.parisinfo.com/var/otcp/sites/images/node_43/node_51/node_77884/node_77888/france-miniature-enfants-%C3%A0-l'arc-de-triomphe-%7C-630x405-%7C-%C2%A9-jl-bellurget/12025400-1-fre-FR/France-Miniature-Enfants-%C3%A0-l'arc-de-triomphe-%7C-630x405-%7C-%C2%A9-JL-Bellurget.jpg",
                paris,
                new TAGS[]{Romantic, SiteSeeing, Art}));
    }
}
