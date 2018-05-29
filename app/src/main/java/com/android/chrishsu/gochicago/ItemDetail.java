package com.android.chrishsu.gochicago;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemDetail extends AppCompatActivity {
    final ArrayList<Item> mItems = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        String item_title = getIntent().getStringExtra("ITEM_TITLE");
        setTitle(item_title);

        initItems(mItems);

        int currentItemIndex = getItemIndexByTitle(item_title);

        inflateLayout(currentItemIndex);


    }

    private void inflateLayout(int index) {
        ImageView itemImage = (ImageView) findViewById(R.id.item_image);
        itemImage.setImageResource(mItems.get(index).getImageResourceId());

        TextView itemTitle = (TextView) findViewById(R.id.item_title);
        itemTitle.setText(mItems.get(index).getTitle());

        TextView itemLocation = (TextView) findViewById(R.id.item_location);
        itemLocation.setText(mItems.get(index).getLocation());

        TextView itemProvider = (TextView) findViewById(R.id.item_provider);
        itemProvider.setText(getString(R.string.item_provider_txt,
                mItems.get(index).getProvider()));

        TextView itemHighlight = (TextView) findViewById(R.id.item_hightlights);
        String[] highlights = mItems.get(index).getHighlights();
        String highlights_text = "";

        for (int i=0; i < highlights.length; i++) {
            highlights_text += "* " + highlights[i] + "\n\n";
        }
        itemHighlight.setText(highlights_text);

        TextView itemOverview = (TextView) findViewById(R.id.item_overview);
        itemOverview.setText(mItems.get(index).getOverview());

        TextView itemPrice = (TextView) findViewById(R.id.item_price);

        itemPrice.setText(getString(R.string.item_price_txt,
                String.valueOf(mItems.get(index).getPrice())));
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
        } catch(Error error) {
            //skip error checking
        }
        return -1;
    }

    private void initItems(ArrayList<Item> items) {

        items.add(new Item("Chicago Architecture River Cruise",
                R.drawable.sights_chicago_architecture_tour,
                "Michigan Ave",
                5,
                new String[] {"See all of Chicago's architectural masterpieces in a single tour",
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

        items.add(new Item("Millennium Park",
                R.drawable.sights_millennium_park,
                "Michigan Ave",
                5,
                new String[] {"Guided Chicago city tour includes areas that many other tours skip",
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

        items.add(new Item("Navy Pier",
                R.drawable.sights_navy_pier,
                "E Grand Ave",
                5,
                new String[] {"Exceptional service to our guests and partners",
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

        items.add(new Item("Skydeck Chicago Admission",
                R.drawable.sights_skydeck,
                "Wacker Drive",
                5,
                new String[] {"Enjoy views of Chicago from the 103rd floor of Willis Tower",
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

        items.add(new Item("History and Riverwalk Tour",
                R.drawable.sights_riverwalk,
                "Michigan Ave",
                5,
                new String[] {"Enjoy a historical walking tour of downtown Chicago",
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

        items.add(new Item("The Art Institute of Chicago",
                R.drawable.sights_art_institute,
                "Grant Park",
                4,
                new String[] {"Fast Pass Admission to the Art Institute of Chicago, located " +
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

        items.add(new Item("Lou Malnati's Pizzeria",
                R.drawable.sights_art_institute,
                "State St",
                5,
                new String[] {"Fast Pass Admission to the Art Institute of Chicago, located " +
                        "in Grant Park. Bypass General Admission lines and gain expedited " +
                        "access to collection galleries and special exhibitions",
                        "Browse an extraordinary collection of Impressionist and modern art",
                        "Admire masterpieces by artists such as Monet, Renoir, Seurat, " +
                                "van Gogh, Chagall and Pollock",
                        "Complimentary tour available daily at noon; guests under 14 years " +
                                "of age receive free admission!"},
                "Lou Malnati’s opened the doors to its 33rd pizzeria on Monday, July 4, 2011. Located at 1120 N. State Street in the city’s Gold Coast neighborhood, this pizzeria is the company’s new flagship location, and has the largest seating capacity of all the Malnati restaurants to date. Lou Malnati's is famous for its Chicago-style deep dish pizza and has become a staple for local Chicagoans, as well as a mandatory destination for tourists.",
                "Lou Malnati's Pizzeria",
                (float) 5));


    }
}
