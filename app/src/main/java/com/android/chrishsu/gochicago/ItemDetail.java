package com.android.chrishsu.gochicago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//Create ItemDetail Activity
public class ItemDetail extends AppCompatActivity {
    //Init a global mItems
    final ArrayList<Item> mItems = new ArrayList<Item>();

    //Override onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        //First, retrieve string value from Intent
        String itemTitle = getIntent().getStringExtra("ITEM_TITLE");

        //Set its title
        setTitle(itemTitle);

        //Init all the item data
        initItems(mItems);

        //Get the current item index
        int currentItemIndex = getItemIndexByTitle(itemTitle);

        //Inflate layout
        inflateLayout(currentItemIndex);

    }

    //Function to inflate layout by position index
    private void inflateLayout(int index) {
        //Get image view and set its resource ID
        ImageView itemImage = findViewById(R.id.item_image);
        itemImage.setImageResource(mItems.get(index).getImageResourceId());

        //Get title view and set its value
        TextView itemTitle = findViewById(R.id.item_title);
        itemTitle.setText(mItems.get(index).getTitle());

        //Get location view and set its value
        TextView itemLocation = findViewById(R.id.item_location);
        itemLocation.setText(mItems.get(index).getLocation());

        //Get provide view and set its value
        TextView itemProvider = findViewById(R.id.item_provider);
        itemProvider.setText(getString(R.string.item_provider_txt,
                mItems.get(index).getProvider()));

        //Get hightlights view
        TextView itemHighlight = findViewById(R.id.item_hightlights);

        //Create a String array for current item's string list
        String[] highlights = mItems.get(index).getHighlights();

        //Create a a new String array
        String highlights_text = "";

        //Loop through the value and manipulate the string list
        for (int i = 0; i < highlights.length; i++) {
            //Adds * to each list, and break at the end
            highlights_text += "* " + highlights[i] + "\n\n";
        }
        //Set the final string list value to the view
        itemHighlight.setText(highlights_text);

        //Get overview view and set its value
        TextView itemOverview = findViewById(R.id.item_overview);
        itemOverview.setText(mItems.get(index).getOverview());

        //Get price view and set its value
        TextView itemPrice = findViewById(R.id.item_price);
        itemPrice.setText(getString(R.string.item_price_txt,
                String.valueOf(mItems.get(index).getPrice())));
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private int getItemIndexByTitle(String title) {
        try {
            for (int i = 0; i < mItems.size(); i++) {
                Item currentItem = mItems.get(i);
                String currentTitle = currentItem.getTitle();
                if (title.equals(currentTitle)) {
                    return i;
                }
            }
        } catch (Error error) {
            //skip error checking
        }
        return -1;
    }

    //Function to init and create item data
    private void initItems(ArrayList<Item> items) {

        items.add(new Item(getString(R.string.tour_chicago_architecture_title),
                R.drawable.sights_chicago_architecture_tour,
                getString(R.string.tour_chicago_architecture_location),
                Integer.parseInt(getString(R.string.tour_chicago_architecture_review)),
                new String[]{"See all of Chicago's architectural masterpieces in a single tour",
                        "Choose from multiple departure times to fit your busy schedule",
                        "Learn about the city's architectural history through an expert's live narration",
                        "Prebook this must-do Chicago activity, which frequently sells out"},
                "Get views of Chicago’s most famous buildings, " +
                        "as well as insider info from an expert guide, " +
                        "on this architecture-focused cruise. " +
                        "You’ll see all the most important buildings on one tour, " +
                        "a hard-to-accomplish task by foot. \n\nView the skyline from " +
                        "the Chicago River while listening to live commentary. " +
                        "Snap photos of the Willis (Sears) Tower, Old Post Office, " +
                        "360 Chicago Observation Deck, Wrigley Building, and Aon Center.",
                "Shoreline Sightseeing",
                (float) 43.68));

        items.add(new Item(getString(R.string.tour_millennium_park_title),
                R.drawable.sights_millennium_park,
                getString(R.string.tour_millennium_park_location),
                Integer.parseInt(getString(R.string.tour_millennium_park_review)),
                new String[]{"Guided Chicago city tour includes areas that many other tours skip",
                        "Travel with a small group, which ensures personalized attention",
                        "Air-conditioned minibus can travel where larger coaches can't navigate",
                        "Upgrade to include a popular Chicago River architecture boat cruise"},
                "Check many Chicago's landmarks off your must-see " +
                        "list with this small-group sightseeing tour aboard " +
                        "a minibus. Cover more ground than on foot, and hit " +
                        "lots of highlights over the tour. \n\nYou’ll see the " +
                        "Museum Campus, Rookery, and Lincoln Park, accompanied " +
                        "by in-depth commentary from your guide. Upgrade to " +
                        "include a 75-minute Chicago architecture tour by boat, " +
                        "one of the most popular tours in the city.",
                "See it All Chicago Tours",
                (float) 35));

        items.add(new Item(getString(R.string.tour_navy_pier_title),
                R.drawable.sights_navy_pier,
                getString(R.string.tour_navy_pier_location),
                Integer.parseInt(getString(R.string.tour_navy_pier_review)),
                new String[]{"Exceptional service to our guests and partners",
                        "An authentic Chicago experience",
                        "An architecturally stunning environment offering access " +
                                "to extraordinary vistas of the lake, land and skyline"},
                "Originally completed in 1916 as part of Daniel Burnham's plan for " +
                        "Chicago, Navy Pier is an iconic city landmark inspiring discovery and " +
                        "wonder. \n\nSince its reopening in 1995, more than 180 million visitors " +
                        "have come to enjoy the Pier's 50 acres of unparalleled attractions " +
                        "and experiences. As Navy Pier enters its second century, the venue is " +
                        "evolving into an accessible, year-round centerpiece for Chicago’s " +
                        "diverse arts and cultural treasures.",
                "Navy Pier",
                (float) 25));

        items.add(new Item(getString(R.string.tour_skydeck_title),
                R.drawable.sights_skydeck,
                getString(R.string.tour_skydeck_location),
                Integer.parseInt(getString(R.string.tour_skydeck_review)),
                new String[]{"Enjoy views of Chicago from the 103rd floor of Willis Tower",
                        "Experience the thrill of the Ledge, a glass balcony 1,353 feet " +
                                "(412.4 meters) off the ground",
                        "Learn about the history of the Skydeck in the Skydeck Theatre",
                        "Explore interactive exhibits designed for the whole family",
                        "With mobile tickets, simply scan your phone for direct entry"},
                "Visit the Skydeck, located on the 103rd floor of the Willis Tower " +
                        "(formerly the Sears Tower) with this pre-paid admission ticket. " +
                        "From the highest point in the city, look out on Chicago's skyline for " +
                        "panoramic views of the sprawling Windy City. Peruse the interactive " +
                        "displays and exhibits showcasing Chicago's history, which are geared " +
                        "toward curious learners of all ages. Then walk out on to the Ledge, " +
                        "a glass balcony that allows views of Navy Pier and Wrigley Field from " +
                        "one of the world's tallest buildings, standing 1,353 feet " +
                        "(412.4 meters) tall.",
                "Skydeck",
                (float) 24));

        items.add(new Item(getString(R.string.tour_riverwalk_title),
                R.drawable.sights_riverwalk,
                getString(R.string.tour_riverwalk_location),
                Integer.parseInt(getString(R.string.tour_riverwalk_review)),
                new String[]{"Enjoy a historical walking tour of downtown Chicago",
                        "Compare the city’s past with its present",
                        "Learn about the history of the Skydeck in the Skydeck Theatre",
                        "See some of the city’s most popular attractions and landmark locations",
                        "Pictorial view book plus headset included"},
                "Discover the true story of Chicago’s history and learn how this " +
                        "once-swampland became one of the biggest and most-popular cities " +
                        "in the world on this 2.5-hour walking tour. Hear stories about " +
                        "the Windy City’s past — from the Fort Dearborn Massacre to the " +
                        "Great Chicago Fire, the 1893 World’s Fair and much more. \n\nStroll " +
                        "the streets, across the Michigan Avenue Bridge to the Chicago " +
                        "Riverwalk and beyond. Also included: a personal, pictorial view " +
                        "book to compare the city’s past with the present plus a headset to " +
                        "hear the guide clearly.",
                "Chicago's Finest Tours",
                (float) 25));

        items.add(new Item(getString(R.string.tour_art_institute_title),
                R.drawable.sights_art_institute,
                getString(R.string.tour_art_institute_location),
                Integer.parseInt(getString(R.string.tour_art_institute_review)),
                new String[]{"Fast Pass Admission to the Art Institute of Chicago, located " +
                        "in Grant Park. Bypass General Admission lines and gain expedited " +
                        "access to collection galleries and special exhibitions",
                        "Browse an extraordinary collection of Impressionist and modern art",
                        "Admire masterpieces by artists such as Monet, Renoir, Seurat, " +
                                "van Gogh, Chagall and Pollock",
                        "Complimentary tour available daily at noon; guests under 14 years " +
                                "of age receive free admission!"},
                "Explore the Art Institute, Chicago’s world-class art museum " +
                        "and the second-largest in the United States, with this Fast Pass " +
                        "Admission ticket. Situated in Grant Park, the museum’s incredible " +
                        "range of impressionist, post-impressionist, modern and contemporary " +
                        "works is near the top of the list of Chicago’s must-see sights.\n\n" +
                        "Among the artists on display are works by Pollack, van Gogh, " +
                        "Renoir, Monet and Picasso plus, plus a striking new Modern Wing " +
                        "and cutting edge graphic and industrial design.",
                "The Art Institute",
                (float) 35));

        items.add(new Item(getString(R.string.food_lou_malanti_title),
                R.drawable.food_lou_malnati_pizza,
                getString(R.string.food_lou_malanti_location),
                Integer.parseInt(getString(R.string.food_lou_malanti_review)),
                new String[]{"Italian", "Pizza", "Vegetarian Friendly",
                        "Vegan Options", "Gluten Free Options"},
                "Lou Malnati’s opened the doors to its 33rd pizzeria on Monday, " +
                        "July 4, 2011. Located at 1120 N. State Street in the city’s " +
                        "Gold Coast neighborhood, this pizzeria is the company’s new " +
                        "flagship location, and has the largest seating capacity of " +
                        "all the Malnati restaurants to date. \n\nLou Malnati's is famous " +
                        "for its Chicago-style deep dish pizza and has become a staple " +
                        "for local Chicagoans, as well as a mandatory destination for tourists.",
                "Lou Malnati's Pizzeria",
                (float) 5));

        items.add(new Item(getString(R.string.food_girl_the_goat_title),
                R.drawable.food_girl_and_the_goat,
                getString(R.string.food_girl_the_goat_location),
                Integer.parseInt(getString(R.string.food_girl_the_goat_review)),
                new String[]{"American", "Vegetarian Friendly",
                        "Gluten Free Options", "Vegan Options"},
                "Girl & the Goat has been serving fun foods, craft beers, " +
                        "and making wine in a rustic and kick-butt environment since " +
                        "summer 2010. The restaurant opens at 4:30 every day, and stays " +
                        "open until 11pm on weeknights and until midnight on Fridays " +
                        "and Saturdays (until those last late night eaters scrape their " +
                        "fork across the plate for the last time, or finish licking " +
                        "their plates until they're shiny and clean). \n\nThe Goat's menu " +
                        "is divided into three categories: Vegetable, Fish, and of " +
                        "course Meat--while vegetable, fish, or meat are respectively " +
                        "the main stars of their categories, there are crossovers in " +
                        "each area so you'll get a little bit of everything.",
                "Girl & The Goat",
                (float) 15));

        items.add(new Item(getString(R.string.food_portillo_title),
                R.drawable.food_portillos,
                getString(R.string.food_portillo_location),
                Integer.parseInt(getString(R.string.food_portillo_review)),
                new String[]{"American", "Fast Food", "Soups", "Vegetarian Friendly"},
                "Home to America's favorite Chicago-style hot dogs, Italian " +
                        "beef, burgers, salads, and chocolate cake. \n\nThe first " +
                        "Portillo's hot dog stand known as \"The Dog House\" opens " +
                        "in 1963 on North Avenue in Villa Park. Owner and founder " +
                        "Dick Portillo invests $1,100 into a 6' x 12' trailer " +
                        "without a bathroom or running water. To get the water " +
                        "he needs, he runs 250 feet of garden hose from a nearby " +
                        "building into the trailer.",
                "Portillo's",
                (float) 10));

        items.add(new Item(getString(R.string.food_wildberry_title),
                R.drawable.food_wildberry,
                getString(R.string.food_wildberry_location),
                Integer.parseInt(getString(R.string.food_wildberry_review)),
                new String[]{"American", "Cafe", "Vegetarian Friendly",
                        "Vegan Options", "Gluten Free Options"},
                "Get your day off to a great start” at this " +
                        "“slightly upscale” " +
                        "breakfast- and lunch-only pancake chain, where an " +
                        "“amazingly big” American menu offers “more flair” " +
                        "than expected plus “huge”, “reasonably priced” " +
                        "portions; it's “mobbed” on weekends, so “be prepared " +
                        "to wait.",
                "Wildberry ",
                (float) 15));

        items.add(new Item(getString(R.string.food_smoque_title),
                R.drawable.food_smoqu_bbq,
                getString(R.string.food_smoque_location),
                Integer.parseInt(getString(R.string.food_smoque_review)),
                new String[]{"American", "Barbecue", "Gluten Free Options"},
                "Smoque (smōk) BBQ is a neighborhood kind of place that cooks up " +
                        "BBQ good enough to make it a true destination. It was created by " +
                        "five regular guys who happen to be passionate about food in general " +
                        "and BBQ in particular.",
                "Smoque BBQ ",
                (float) 20));

        items.add(new Item(getString(R.string.food_bohemian_title),
                R.drawable.food_bohemian_house,
                getString(R.string.food_bohemian_location),
                Integer.parseInt(getString(R.string.food_bohemian_review)),
                new String[]{"German", "Polish", "European", "Czech",
                        "Eastern European", "Central European",
                        "Hungarian", "Austrian", "Vegetarian Friendly",
                        "Gluten Free Options"},
                "Located in Chicago's River North neighborhood at State and " +
                        "Illinois (11 W. Illinois), Bohemian House captures the " +
                        "lighthearted and carefree essence of Bohemian culture. " +
                        "Exposed brick walls and wood timber, eclectic décor, warm " +
                        "earth tones and soft lighting set the backdrop for a comfortable " +
                        "and sociable dining experience. Guest can expect to enjoy an " +
                        "original menu of approachable Bohemian-inspired fare with " +
                        "influences from the Czech Repulic, Germany and Austria. \n\nAcquainting " +
                        "Central Europe to the Central U.S., our culinary team takes a " +
                        "fresh approach to traditional favorites, utilizing the best of " +
                        "what's in season. ",
                "Bohemian House",
                (float) 20));

        items.add(new Item(getString(R.string.hotel_peninsula_title),
                R.drawable.hotel_the_peninsula,
                getString(R.string.hotel_peninsula_location),
                Integer.parseInt(getString(R.string.hotel_peninsula_review)),
                new String[]{"Free Wifi", "Breakfast Available",
                        "Air Conditioning", "Pool",
                        "Non-Smoking Hotel"},
                "Located at Water Tower Park on the \"Manificent Mile,\" the " +
                        "city’s premier shopping district, The Peninsula Chicago is the " +
                        "city's most luxurious and sophisticated hotel, offering " +
                        "guests all possible amenities and services. The Peninsula " +
                        "Chicago is a proud recipient of the Five-Star, Five-Diamond " +
                        "Award, and was also recently awarded \"#1 Large City Hotel In " +
                        "US And Canada\" by readers of Travel + Leisure.",
                "The Peninsula Chicago",
                (float) 525));

        items.add(new Item(getString(R.string.hotel_langham_title),
                R.drawable.hotel_the_langham,
                getString(R.string.hotel_langham_location),
                Integer.parseInt(getString(R.string.hotel_langham_review)),
                new String[]{"Free Wifi", "Parking", "Breakfast Available",
                        "Air Conditioning", "Pool",
                        "Non-Smoking Hotel", "Restaurant"},
                "Legendary service and timeless British style in an iconic Chicago " +
                        "landmark. The perfect blend of convenience and luxurious comfort " +
                        "only at The Langham, Chicago. \n\nThe Langham, Chicago is " +
                        "conveniently located within walking distance of the city's " +
                        "business district, major attractions and Chicago’s retail hub, " +
                        "Magnificent Mile, making the hotel an ideal base from which " +
                        "to explore the city or conduct business.",
                "The Langham, Chicago",
                (float) 547));

        items.add(new Item(getString(R.string.hotel_ace_title),
                R.drawable.hotel_ace_chicago,
                getString(R.string.hotel_ace_location),
                Integer.parseInt(getString(R.string.hotel_ace_review)),
                new String[]{"Free Wifi", "Breakfast Available",
                        "Air Conditioning", "Non-Smoking Hotel",
                        "Restaurant", "Room Service", "Suites"},
                "Ace Hotel Chicago lives in a stoic, industrial concrete " +
                        "and glass building in the West Loop, once home to an " +
                        "Italian-American cheesemaking company and, before that, " +
                        "a pair of mysterious brothers. \n\nWe're walking distance to " +
                        "the Morgan Lake L Station and some of the best food in " +
                        "the city. You can throw a coin and hit Google (we don't " +
                        "recommend it, they've got cameras) and what once was " +
                        "Oprah Winfrey's HQ.",
                "Ace Hotel Chicago",
                (float) 404));

        items.add(new Item(getString(R.string.hotel_guesthouse_title),
                R.drawable.hotel_the_guesthouse,
                getString(R.string.hotel_guesthouse_location),
                Integer.parseInt(getString(R.string.hotel_guesthouse_review)),
                new String[]{"Free Wifi", "Air Conditioning",
                        "Non-Smoking Hotel", "Room Service", "Suites",
                        "Fitness Center", "Kitchenette"},
                "The Guesthouse Hotel was originally built in 2008 as " +
                        "boutique condominiums, but soon found its groove as a place " +
                        "for 10 unique—and spacious—vacation rentals. \n\nIn 2013, " +
                        "The Guesthouse broke ground on a new building next door, " +
                        "adding 15 more deluxe units, and a lobby, club room, retail " +
                        "space, business center, and gym, to fully develop into an " +
                        "all-accommodating boutique hotel.",
                "The Guesthouse Hotel",
                (float) 499));

        items.add(new Item(getString(R.string.hotel_emc2_title),
                R.drawable.hotel_emc2,
                getString(R.string.hotel_emc2_location),
                Integer.parseInt(getString(R.string.hotel_emc2_review)),
                new String[]{"Wifi", "Parking", "Breakfast Buffet",
                        "Air Conditioning", "Non-Smoking Hotel",
                        "Restaurant", "Room Service"},
                "Immerse yourself in downtown Chicago's creative culture at " +
                        "Hotel EMC2, Autograph Collection. Located in Streeterville, " +
                        "our boutique hotel is within walking distance of the Theater " +
                        "District, Navy Pier and a plethora of shops and eateries along " +
                        "The Magnificent Mile. ",
                "Hotel EMC2, Autograph Collection",
                (float) 390));

        items.add(new Item(getString(R.string.hotel_kimption_title),
                R.drawable.hotel_kimpton,
                getString(R.string.hotel_kimption_location),
                Integer.parseInt(getString(R.string.hotel_kimption_review)),
                new String[]{"Free Internet", "Breakfast Available",
                        "Air Conditioning", "Non-Smoking Hotel",
                        "Restaurant", "Room Service", "Suites"},
                "Smackdab in the center of downtown Chicago on the River, " +
                        "Kimpton Hotel Monaco Chicago combines a desirable Loop location " +
                        "with a fun design, warm hospitality, and Kimpton touches like " +
                        "complimentary nightly wine hour. \n\nFrom your guestroom or suite, " +
                        "take in the city lights and river views from your window seat " +
                        "(tip: the perfect backdrop for photos), then head downstairs to " +
                        "our new Belgian bistro-inspired mussel & beer bar, Fisk & Co, " +
                        "featuring a mouthwatering menu of mussels, oysters, steak fries, " +
                        "and burgers.",
                "Kimpton Hotel Monaco Chicago",
                (float) 320));

        items.add(new Item(getString(R.string.mustsee_wrigley_title),
                R.drawable.mustsee_wrigley_field,
                getString(R.string.mustsee_wrigley_location),
                Integer.parseInt(getString(R.string.mustsee_wrigley_review)),
                new String[]{"Seating bowl", "Press box",
                        "Budweiser Bleachers", "Visitors' clubhouse",
                        "Cubs' dugout", "Field"},
                "Get a behind-the-scenes look at the legendary home of the Chicago " +
                        "Cubs with Wrigley Field Tours. Built in 1914, this must-see Chicago " +
                        "attraction houses more than 100 years of history.",
                "Arenas & Stadiums",
                (float) 24));

        items.add(new Item(getString(R.string.mustsee_mcdonald_title),
                R.drawable.mustsee_mcdonald_no1_store,
                getString(R.string.mustsee_mcdonald_location),
                Integer.parseInt(getString(R.string.mustsee_mcdonald_review)),
                new String[]{"Specialty Museums", "Museums"},
                "McDonald's #1 Store Museum is a recreation of the first McDonald's " +
                        "Restaurant opened in Des Plaines, Illinois by McDonald's Corporation " +
                        "founder, Ray Kroc, on April 15, 1955.",
                "McDonald's",
                (float) 0));

        items.add(new Item(getString(R.string.mustsee_uc_title),
                R.drawable.mustsee_university_of_chicago,
                getString(R.string.mustsee_uc_location),
                Integer.parseInt(getString(R.string.mustsee_uc_review)),
                new String[]{"Educational sites", "Universities & Schools", "Sights & Landmarks"},
                "Welcome to the University of Chicago! Founded in 1890 through a gift " +
                        "from John D. Rockefeller, the University of Chicago is an intellectual " +
                        "destination and one of the world's premier academic institutions " +
                        "for inquiry, education, and discovery. ",
                "University of Chicago",
                (float) 0));

        items.add(new Item(getString(R.string.mustsee_loop_title),
                R.drawable.mustsee_the_loop,
                getString(R.string.mustsee_loop_location),
                Integer.parseInt(getString(R.string.mustsee_loop_review)),
                new String[]{"Get to know the Loop, Chicago’s lively downtown area",
                        "Experience the beauty of this urban metropolis on foot",
                        "Local guide shares insider knowledge of the city"},
                "Step into the heart of Chicago with this 2-hour walking tour " +
                        "of the Loop. You’ll meet your local guide at the Chicago " +
                        "Cultural Center and make your way through the city’s downtown. " +
                        "\n\nStop to check out the elevated “L” train, buildings by Burnham " +
                        "and Sullivan, busy commercial centers and lesser-known quiet " +
                        "corners of this vibrant area. You’ll come away with a deeper " +
                        "sense of Chicago’s rich history and architecture.",
                "Wild Onion Walks Chicago",
                (float) 30));

        items.add(new Item(getString(R.string.mustsee_united_title),
                R.drawable.mustsee_united_center,
                getString(R.string.mustsee_united_location),
                Integer.parseInt(getString(R.string.mustsee_united_review)),
                new String[]{"Arenas & Stadiums", "Sights & Landmarks"},
                "This modern arena replaced the old Chicago Stadium as home " +
                        "court for the NBA's Bulls and the NHL's Blackhawks.",
                "United Center",
                (float) 15));

        items.add(new Item(getString(R.string.mustsee_robie_title),
                R.drawable.mustsee_robie_house,
                getString(R.string.mustsee_robie_location),
                Integer.parseInt(getString(R.string.mustsee_robie_review)),
                new String[]{"Architectural Buildings", "Historic Sites",
                        "Sights & Landmarks"},
                "The Robie House on the University of Chicago campus is considered " +
                        "one of the most important buildings in the history of American " +
                        "architecture. \n\nIt was created by Frank Lloyd Wright for his client " +
                        "Frederick C. Robie, a forward-thinking businessman. ",
                "Robie House",
                (float) 18));

    }
}
