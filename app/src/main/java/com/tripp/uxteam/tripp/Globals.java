package com.tripp.uxteam.tripp;

import java.util.LinkedList;

// general attraction tags
enum TAGS {
    Hiking,
    Romantic,
    Beaches,
    Theater,
    Parties,
    SiteSeeing,
    Food,
    Extreme,
    Art,
    Nature,
    Concerts,
    Festivals,
    Shopping
};

public class Globals {
    public static User currentSessionUser = new User(new double[]{0.5, 0.5, 0.5, 0.5});

    public static LinkedList<User> users = new LinkedList<>();

    public static User user1 = new User(new double[]{0.69, 0.22, 0.08, 0.01});
    public static User user2 = new User(new double[]{0, 0.8, 0.1, 0.1});
    public static User user3 = new User(new double[]{0.04, 0.15, 0.81, 0});
    public static User user4 = new User(new double[]{0, 0, 0.17, 0.83});

    public static Trip currentTrip;
    public static Trip parisTrip = new Trip("Paris", new double[]{0.5, 0.425, 0.075, 0});
    public static Trip thailandTrip = new Trip("Thailand", new double[]{0.1, 0.7, 0.2, 0});
    public static Trip telAvivTrip = new Trip("Tel Aviv", new double[]{0.05, 0.05, 0.9, 0});
    public static Trip patagoniaTrip = new Trip("Patagonia", new double[]{0, 0, 0.2, 0.8});

    static {
        //add Paris trip attractions
        parisTrip.addAttraction(new Attraction("Eiffel Tower", "eiffel_tower", "https://www.google.com/maps/search/?api=1&query=eiffel_tower", "https://www.tripadvisor.com/AttractionProductReview-g187147-d11472816-Eiffel_Tower_Priority_Access_Ticket_with_Host-Paris_Ile_de_France.html", "This colossal landmark, although initially hated by many Parisians, is now a famous symbol of French civic pride.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Seine River", "seine_river", "https://www.google.com/maps/search/?api=1&query=seine+river", "https://www.tripadvisor.com/Attraction_Review-g187147-d189683-Reviews-Seine_River-Paris_Ile_de_France.html", "This famous river flows from east to west through the heart of the city and divides Paris's " +
                "Left Bank and Right Bank.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Saint Chapelle", "saint_chapelle", "https://www.google.com/maps/search/?api=1&query=saint+chapelle", "https://www.tripadvisor.com/Attraction_Review-g187147-d190202-Reviews-Sainte_Chapelle-Paris_Ile_de_France.html", "Adorned with a unique collection of fifteen glass panels and a large rose window forming a " +
                "veritable wall of light, it is a gem of French Gothic architecture.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Notre Dame", "notre_dame", "https://www.google.com/maps/search/?api=1&query=notre+dame", "https://www.tripadvisor.com/Attraction_Review-g187147-d188679-Reviews-Cathedrale_Notre_Dame_de_Paris-Paris_Ile_de_France.html", "This famous cathedral, a masterpiece of Gothic architecture, stands on the Île de la Cité " +
                "and is the symbolic heart of the city.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Lafayette Gourment", "lafayette_gourmet", "https://www.google.com/maps/search/?api=1&query=lafayette+gourmet", "https://www.tripadvisor.com/Attraction_Review-g187147-d189193-Reviews-Galeries_Lafayette_Paris_Haussmann-Paris_Ile_de_France.html", "Food and drinks served with a pinch of city buzz. No trip to " +
                "paris is complete without breathing in the scents and vibes of this lively market.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("The Louvre", "the_louvre", "https://www.google.com/maps/search/?api=1&query=the+louvre", "https://www.tripadvisor.com/Attraction_Review-g187147-d188757-Reviews-Louvre_Museum-Paris_Ile_de_France.html?m=19905", "Home to Leonardo da Vinci's Mona Lisa, the Louvre is considered the world's greatest art museum, " +
                "covering the full spectrum of art through the ages.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Versailles", "versailles", "https://www.google.com/maps/search/?api=1&query=versailles", "https://www.tripadvisor.com/Attraction_Review-g187148-d188681-Reviews-Palace_of_Versailles-Versailles_Yvelines_Ile_de_France.html", "Take day-trip to this beautiful city just an hour away from Paris. " +
                "Walk around and enjoy the local french life untroubled by tourists.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Matamata Coffee", "matamata_coffee", "https://www.google.com/maps/search/?api=1&query=matamata+coffee", "https://www.tripadvisor.com/Restaurant_Review-g187147-d7105735-Reviews-Matamata_Coffee_Bar-Paris_Ile_de_France.html", "Classic coffee shop loved by locals and tourists alike, known for great pastries " +
                "and coffee from around the globe.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Musee Dorsay", "musee_dorsay", "https://www.google.com/maps/search/?api=1&query=musee+dorsay", "https://www.tripadvisor.com/Attraction_Review-g187147-d188150-Reviews-Musee_d_Orsay-Paris_Ile_de_France.html", "This beautiful museum, once a railroad station, now houses a staggering collection of " +
                "Impressionist art, as well as other items created between 1848 and 1914.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Berthillon Glaciet", "berthillon_glaciet", "https://www.google.com/maps/search/?api=1&query=berthillon+glaciet", "https://www.tripadvisor.com/Attraction_Review-g187147-d189231-Reviews-Berthillon-Paris_Ile_de_France.html", "The best ice cream paris has to offer. It also serves a versatile collection of classic " +
                "and modern desserts.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Arc De Triomphe", "arc_de_triomphe", "https://www.google.com/maps/search/?api=1&query=arc+de+triomphe", "https://www.tripadvisor.com/AttractionProductReview-g187147-d12152818-Skip_the_Line_Arc_de_Triomphe_Including_Terrace_Access-Paris_Ile_de_France.html",
                "Inspired by the great arches of antiquity, the monument combines the commemorative with the " +
                "symbolic. It plays a major role in the national consciousness.", new double[]{0, 0, 0, 0}));
        parisTrip.addAttraction(new Attraction("Jadis Pub", "jadis_pub", "https://www.google.com/maps/search/?api=1&query=jadis+pub", "https://www.tripadvisor.com/Restaurant_Review-g187147-d2147986-Reviews-Caffe_Jadis-Paris_Ile_de_France.html", "Relaxing pub with a welcoming warm vibe. The pub serves an enormous number of draft " +
                "beers as well as exceptional pub food.", new double[]{0, 0, 0, 0}));


        //add Tel-Aviv trip attractions
        telAvivTrip.addAttraction(new Attraction("Dizingof Pub Crawl", "dizingof_pub_crawl", "https://www.google.com/maps/search/?api=1&query=dizingof+pubs+tell+aviv", "https://www.tripadvisor.com",  "Join a tourist group and explore pubs in the lively Dizingof street, each with its unique atmosphere and characters.", new double[]{0, 0, 0, 0}));
        telAvivTrip.addAttraction(new Attraction("Graffiti Tour", "graffiti_tour", "https://www.google.com/maps/search/?api=1&query=graffiti+tour+tel+aviv", "https://www.tripadvisor.com", "Join a group and discover what this lively city has to offer as you observe edgy street art scattered all around the city.", new double[]{0, 0, 0, 0}));
        telAvivTrip.addAttraction(new Attraction("Kuli Alma", "kuli_alma", "https://www.google.com/maps/search/?api=1&query=kuli+alma+tel+aviv", "https://www.tripadvisor.com", "Sit down for a drink at this relaxing bar loved by locals. Often plays alternative chill music. Suitable for early afternoon drinks as well as a late night out.", new double[]{0, 0, 0, 0}));
        telAvivTrip.addAttraction(new Attraction("Laser Tag", "laser_tag", "https://www.google.com/maps/search/?api=1&query=laser+tag+tel+aviv", "https://www.tripadvisor.com",  "Get your adrenaline pump playing laser tag at one of many recommended locations. This game is also a great way to meet new people on your trip.", new double[]{0, 0, 0, 0}));
        telAvivTrip.addAttraction(new Attraction("Potion Bar", "potion_bar", "https://www.google.com/maps/search/?api=1&query=potion+bar+tel+aviv", "https://www.tripadvisor.com",  "A unique bar specializing in potion like cocktails. Offers a mixed vibe of a classical cocktail place with the darker, electro-music driven feel of a local bar.", new double[]{0, 0, 0, 0}));
        telAvivTrip.addAttraction(new Attraction("Rothschild Pub Crawl", "rothschild_pub_crawl", "https://www.google.com/maps/search/?api=1&query=rothschild+pubs+tel+aviv", "https://www.tripadvisor.com", "Join a tourist group and explore pubs in the lively Rothschild street. Venues here are usually open 24/7, hosting night-life loving locals and tourists alike.", new double[]{0, 0, 0, 0}));

        //add Thailand trip attractions
        thailandTrip.addAttraction(new Attraction("Freedom Beach", "freedom_beach", "https://www.google.com/maps/search/?api=1&query=freedom+beach+thailand", "https://www.tripadvisor.com", "A stunning beach that always stays fairly quiet. The sand is soft and white, the sea invitingly warm. A must visit for a relaxing day out.", new double[]{0, 0, 0, 0}));
        thailandTrip.addAttraction(new Attraction("Karon Beach", "karon_beach", "https://www.google.com/maps/search/?api=1&query=karon+beach+thailand", "https://www.tripadvisor.com",  "This uncrowded beach features an incredibly long stretch of white sand and a full range of tourist facilities, dining and outdoor recreation.", new double[]{0, 0, 0, 0}));
        thailandTrip.addAttraction(new Attraction("Patong Boxing Stadium ", "patong_boxing_stadium", "https://www.google.com/maps/search/?api=1&query=patong+boxing+stadium+thailand", "https://www.tripadvisor.com", "Get your daily dose of adrenaline. This boxing stadium holds thrilling, high level boxing matches, that are sure to keep you on your toes.", new double[]{0, 0, 0, 0}));
        thailandTrip.addAttraction(new Attraction("Splash Jungle Water Park", "splash_jungle_water_park", "https://www.google.com/maps/search/?api=1&query=Splash+Jungle+Water+Park+thailand", "https://www.tripadvisor.com", "An exciting water-park for the whole family. The park consists of a lazy river, wave pool, slides, resturants, and a game zone.", new double[]{0, 0, 0, 0}));
        thailandTrip.addAttraction(new Attraction("Surin Beach", "surin_beach", "https://www.google.com/maps/search/?api=1&query=surin+beach+thailand", "https://www.tripadvisor.com", "An amazing place to watch the sun go down whilst sipping on a Mango Daiquiri or imbibe in the delights of true locally prepared Thai food.", new double[]{0, 0, 0, 0}));
        thailandTrip.addAttraction(new Attraction("Trickeye Museum", "trickeye_museum", "https://www.google.com/maps/search/?api=1&query=trickeye+museum+thailand", "https://www.tripadvisor.com", "This first Trickeye 3D Museum in Thailand, is located in Phuket town. it is an interactive museum with a concept that stimulates your creativity and imagination.", new double[]{0, 0, 0, 0}));

        //add Patagonia trip attractions
        patagoniaTrip.addAttraction(new Attraction("Fitz roy", "fitz_roy", "https://www.google.com/maps/search/?api=1&query=fitz+roy+patagonia", "https://www.tripadvisor.com", "The most challenging trek in Chalten, but well worth it. You'll never forget the view of these mountains from Laguna de los Tres. It is forever yours.", new double[]{0, 0, 0, 0}));
        patagoniaTrip.addAttraction(new Attraction("Iguazu Falls", "iguazu_falls", "https://www.google.com/maps/search/?api=1&query=iguazu+falls", "https://www.tripadvisor.com", "The colossal power of these thundering falls is a mesmerizing sight: 275 separate falls in a U-shaped formation, intensely pound the water below.", new double[]{0, 0, 0, 0}));
        patagoniaTrip.addAttraction(new Attraction("Lake Moreno", "lake_moreno", "https://www.google.com/maps/search/?api=1&query=lake+moreno+patagonia", "https://www.tripadvisor.com", "Explore Patagonian on this 5-hour kayaking tour of the lake. Paddle through calm waters and enjoy the area's serene alpine views.", new double[]{0, 0, 0, 0}));
        patagoniaTrip.addAttraction(new Attraction("Perito Moreno", "perito_moreno", "https://www.google.com/maps/search/?api=1&query=perito+moreno+patagonia", "https://www.tripadvisor.com", "A trip to this imposing glacier, the size of a small city, gives you a chance to see and hear blocks of ice rupturing and floating away as icebergs.", new double[]{0, 0, 0, 0}));
        patagoniaTrip.addAttraction(new Attraction("Seven Color Mountain", "six_color_mountain", "https://www.google.com/maps/search/?api=1&query=Paseo+de+los+Colorados+patagonia", "https://www.tripadvisor.com", "One of the most incredible natural sites in north Argentina. The unique colors of this mountain makes it a true natural gem.", new double[]{0, 0, 0, 0}));
        patagoniaTrip.addAttraction(new Attraction("Tronador Glacier", "tronador_glacier", "https://www.google.com/maps/search/?api=1&query=tronador+glacier+patagonia", "https://www.tripadvisor.com", "Behold this impressive large glacier, formed on a cliff side, with a clear water lagoon at its feet. Only a short hike to see it makes it worthwhile for beginners.", new double[]{0, 0, 0, 0}));

        user1.addTrip(parisTrip);
        user2.addTrip(thailandTrip);
        user3.addTrip(telAvivTrip);
        user4.addTrip(patagoniaTrip);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
//        currentTrip = parisTrip;
//        currentTrip = telAvivTrip;
//        currentTrip = thailandTrip;
//        currentTrip = patagoniaTrip;
    }
}