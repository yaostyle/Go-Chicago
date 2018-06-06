package com.android.chrishsu.gochicago;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //First, retrieve string value from Intent
        String itemTitle = getIntent().getStringExtra(getString(R.string.intent_extra_item_title));

        //Set its title
        setTitle(itemTitle);

        //Init all the item data
        initItems(mItems);

        //Get the current item index
        int currentItemIndex = getItemIndexByTitle(itemTitle);

        //Inflate layout
        inflateLayout(currentItemIndex);

    }

    //Override the onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    //Change the behavior for Up-button to act as Back-button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
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
                getResources().getStringArray(R.array.tour_chicago_architecture_highlights),
                getString(R.string.tour_chicago_architecture_overview),
                getString(R.string.tour_chicago_architecture_provider),
                Float.parseFloat(getString(R.string.tour_chicago_architecture_price))));

        items.add(new Item(getString(R.string.tour_millennium_park_title),
                R.drawable.sights_millennium_park,
                getString(R.string.tour_millennium_park_location),
                Integer.parseInt(getString(R.string.tour_millennium_park_review)),
                getResources().getStringArray(R.array.tour_millennium_park_highlights),
                getString(R.string.tour_millennium_park_overview),
                getString(R.string.tour_millennium_park_provider),
                Float.parseFloat(getString(R.string.tour_millennium_park_price))));

        items.add(new Item(getString(R.string.tour_navy_pier_title),
                R.drawable.sights_navy_pier,
                getString(R.string.tour_navy_pier_location),
                Integer.parseInt(getString(R.string.tour_navy_pier_review)),
                getResources().getStringArray(R.array.tour_navy_pier_highlights),
                getString(R.string.tour_navy_pier_overview),
                getString(R.string.tour_navy_pier_provider),
                Float.parseFloat(getString(R.string.tour_navy_pier_price))));

        items.add(new Item(getString(R.string.tour_skydeck_title),
                R.drawable.sights_skydeck,
                getString(R.string.tour_skydeck_location),
                Integer.parseInt(getString(R.string.tour_skydeck_review)),
                getResources().getStringArray(R.array.tour_skydeck_highlights),
                getString(R.string.tour_skydeck_overview),
                getString(R.string.tour_skydeck_provider),
                Float.parseFloat(getString(R.string.tour_skydeck_price))));

        items.add(new Item(getString(R.string.tour_riverwalk_title),
                R.drawable.sights_riverwalk,
                getString(R.string.tour_riverwalk_location),
                Integer.parseInt(getString(R.string.tour_riverwalk_review)),
                getResources().getStringArray(R.array.tour_riverwalk_highlights),
                getString(R.string.tour_riverwalk_overview),
                getString(R.string.tour_riverwalk_provider),
                Float.parseFloat(getString(R.string.tour_riverwalk_price))));

        items.add(new Item(getString(R.string.tour_art_institute_title),
                R.drawable.sights_art_institute,
                getString(R.string.tour_art_institute_location),
                Integer.parseInt(getString(R.string.tour_art_institute_review)),
                getResources().getStringArray(R.array.tour_art_institute_highlights),
                getString(R.string.tour_art_institute_overview),
                getString(R.string.tour_art_institute_provider),
                Float.parseFloat(getString(R.string.tour_art_institute_price))));

        items.add(new Item(getString(R.string.food_lou_malanti_title),
                R.drawable.food_lou_malnati_pizza,
                getString(R.string.food_lou_malanti_location),
                Integer.parseInt(getString(R.string.food_lou_malanti_review)),
                getResources().getStringArray(R.array.food_lou_malanti_highlights),
                getString(R.string.food_lou_malanti_overview),
                getString(R.string.food_lou_malanti_provider),
                Float.parseFloat(getString(R.string.food_lou_malanti_price))));

        items.add(new Item(getString(R.string.food_girl_the_goat_title),
                R.drawable.food_girl_and_the_goat,
                getString(R.string.food_girl_the_goat_location),
                Integer.parseInt(getString(R.string.food_girl_the_goat_review)),
                getResources().getStringArray(R.array.food_girl_the_goat_highlights),
                getString(R.string.food_girl_the_goat_overview),
                getString(R.string.food_girl_the_goat_provider),
                Float.parseFloat(getString(R.string.food_girl_the_goat_price))));

        items.add(new Item(getString(R.string.food_portillo_title),
                R.drawable.food_portillos,
                getString(R.string.food_portillo_location),
                Integer.parseInt(getString(R.string.food_portillo_review)),
                getResources().getStringArray(R.array.food_portillo_highlights),
                getString(R.string.food_portillo_overview),
                getString(R.string.food_portillo_provider),
                Float.parseFloat(getString(R.string.food_portillo_price))));

        items.add(new Item(getString(R.string.food_wildberry_title),
                R.drawable.food_wildberry,
                getString(R.string.food_wildberry_location),
                Integer.parseInt(getString(R.string.food_wildberry_review)),
                getResources().getStringArray(R.array.food_wildberry_highlights),
                getString(R.string.food_wildberry_overview),
                getString(R.string.food_wildberry_provider),
                Float.parseFloat(getString(R.string.food_wildberry_price))));

        items.add(new Item(getString(R.string.food_smoque_title),
                R.drawable.food_smoqu_bbq,
                getString(R.string.food_smoque_location),
                Integer.parseInt(getString(R.string.food_smoque_review)),
                getResources().getStringArray(R.array.food_smoque_highlights),
                getString(R.string.food_smoque_overview),
                getString(R.string.food_smoque_provider),
                Float.parseFloat(getString(R.string.food_smoque_price))));

        items.add(new Item(getString(R.string.food_bohemian_title),
                R.drawable.food_bohemian_house,
                getString(R.string.food_bohemian_location),
                Integer.parseInt(getString(R.string.food_bohemian_review)),
                getResources().getStringArray(R.array.food_bohemian_highlights),
                getString(R.string.food_bohemian_overview),
                getString(R.string.food_bohemian_provider),
                Float.parseFloat(getString(R.string.food_bohemian_price))));

        items.add(new Item(getString(R.string.hotel_peninsula_title),
                R.drawable.hotel_the_peninsula,
                getString(R.string.hotel_peninsula_location),
                Integer.parseInt(getString(R.string.hotel_peninsula_review)),
                getResources().getStringArray(R.array.hotel_peninsula_highlights),
                getString(R.string.hotel_peninsula_overview),
                getString(R.string.hotel_peninsula_provider),
                Float.parseFloat(getString(R.string.hotel_peninsula_price))));

        items.add(new Item(getString(R.string.hotel_langham_title),
                R.drawable.hotel_the_langham,
                getString(R.string.hotel_langham_location),
                Integer.parseInt(getString(R.string.hotel_langham_review)),
                getResources().getStringArray(R.array.hotel_langham_highlights),
                getString(R.string.hotel_langham_overview),
                getString(R.string.hotel_langham_provider),
                Float.parseFloat(getString(R.string.hotel_langham_price))));

        items.add(new Item(getString(R.string.hotel_ace_title),
                R.drawable.hotel_ace_chicago,
                getString(R.string.hotel_ace_location),
                Integer.parseInt(getString(R.string.hotel_ace_review)),
                getResources().getStringArray(R.array.hotel_ace_highlights),
                getString(R.string.hotel_ace_overview),
                getString(R.string.hotel_ace_provider),
                Float.parseFloat(getString(R.string.hotel_ace_price))));

        items.add(new Item(getString(R.string.hotel_guesthouse_title),
                R.drawable.hotel_the_guesthouse,
                getString(R.string.hotel_guesthouse_location),
                Integer.parseInt(getString(R.string.hotel_guesthouse_review)),
                getResources().getStringArray(R.array.hotel_guesthouse_highlights),
                getString(R.string.hotel_guesthouse_overview),
                getString(R.string.hotel_guesthouse_provider),
                Float.parseFloat(getString(R.string.hotel_guesthouse_price))));

        items.add(new Item(getString(R.string.hotel_emc2_title),
                R.drawable.hotel_emc2,
                getString(R.string.hotel_emc2_location),
                Integer.parseInt(getString(R.string.hotel_emc2_review)),
                getResources().getStringArray(R.array.hotel_emc2_highlights),
                getString(R.string.hotel_emc2_overview),
                getString(R.string.hotel_emc2_provider),
                Float.parseFloat(getString(R.string.hotel_emc2_price))));

        items.add(new Item(getString(R.string.hotel_kimption_title),
                R.drawable.hotel_kimpton,
                getString(R.string.hotel_kimption_location),
                Integer.parseInt(getString(R.string.hotel_kimption_review)),
                getResources().getStringArray(R.array.hotel_kimption_highlights),
                getString(R.string.hotel_kimption_overview),
                getString(R.string.hotel_kimption_provider),
                Float.parseFloat(getString(R.string.hotel_kimption_price))));

        items.add(new Item(getString(R.string.mustsee_wrigley_title),
                R.drawable.mustsee_wrigley_field,
                getString(R.string.mustsee_wrigley_location),
                Integer.parseInt(getString(R.string.mustsee_wrigley_review)),
                getResources().getStringArray(R.array.mustsee_wrigley_highlights),
                getString(R.string.mustsee_wrigley_overview),
                getString(R.string.mustsee_wrigley_provider),
                Float.parseFloat(getString(R.string.mustsee_wrigley_price))));

        items.add(new Item(getString(R.string.mustsee_mcdonald_title),
                R.drawable.mustsee_mcdonald_no1_store,
                getString(R.string.mustsee_mcdonald_location),
                Integer.parseInt(getString(R.string.mustsee_mcdonald_review)),
                getResources().getStringArray(R.array.mustsee_mcdonald_highlights),
                getString(R.string.mustsee_mcdonald_overview),
                getString(R.string.mustsee_mcdonald_provider),
                Float.parseFloat(getString(R.string.mustsee_mcdonald_price))));

        items.add(new Item(getString(R.string.mustsee_uc_title),
                R.drawable.mustsee_university_of_chicago,
                getString(R.string.mustsee_uc_location),
                Integer.parseInt(getString(R.string.mustsee_uc_review)),
                getResources().getStringArray(R.array.mustsee_uc_highlights),
                getString(R.string.mustsee_uc_overview),
                getString(R.string.mustsee_uc_provider),
                Float.parseFloat(getString(R.string.mustsee_uc_price))));

        items.add(new Item(getString(R.string.mustsee_loop_title),
                R.drawable.mustsee_the_loop,
                getString(R.string.mustsee_loop_location),
                Integer.parseInt(getString(R.string.mustsee_loop_review)),
                getResources().getStringArray(R.array.mustsee_loop_highlights),
                getString(R.string.mustsee_loop_overview),
                getString(R.string.mustsee_loop_provider),
                Float.parseFloat(getString(R.string.mustsee_loop_price))));

        items.add(new Item(getString(R.string.mustsee_united_title),
                R.drawable.mustsee_united_center,
                getString(R.string.mustsee_united_location),
                Integer.parseInt(getString(R.string.mustsee_united_review)),
                getResources().getStringArray(R.array.mustsee_united_highlights),
                getString(R.string.mustsee_united_overview),
                getString(R.string.mustsee_united_provider),
                Float.parseFloat(getString(R.string.mustsee_united_price))));

        items.add(new Item(getString(R.string.mustsee_robie_title),
                R.drawable.mustsee_robie_house,
                getString(R.string.mustsee_robie_location),
                Integer.parseInt(getString(R.string.mustsee_robie_review)),
                getResources().getStringArray(R.array.mustsee_robie_highlights),
                getString(R.string.mustsee_robit_overview),
                getString(R.string.mustsee_robit_provider),
                Float.parseFloat(getString(R.string.mustsee_robit_price))));
    }
}
