package com.android.chrishsu.gochicago;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

//Create FoodFragment
public class FoodFragment extends Fragment {
    //Create FoodFragment constructor
    public FoodFragment() {
        //empty constructor
    }

    //Override onStart method
    @Override
    public void onStart() {
        super.onStart();
    }

    //Override onCreateView method
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //First, create a rootView and inflate layout from item_listview
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        //Create a ArrayList of Item
        final ArrayList<Item> items = new ArrayList<Item>();

        //Add list data
        items.add(new Item(getString(R.string.food_lou_malanti_title),
                R.drawable.food_lou_malnati_pizza,
                getString(R.string.food_lou_malanti_location),
                Integer.parseInt(getString(R.string.food_lou_malanti_review))));

        items.add(new Item(getString(R.string.food_girl_the_goat_title),
                R.drawable.food_girl_and_the_goat,
                getString(R.string.food_girl_the_goat_location),
                Integer.parseInt(getString(R.string.food_girl_the_goat_review))));

        items.add(new Item(getString(R.string.food_portillo_title),
                R.drawable.food_portillos,
                getString(R.string.food_portillo_location),
                Integer.parseInt(getString(R.string.food_portillo_review))));

        items.add(new Item(getString(R.string.food_wildberry_title),
                R.drawable.food_wildberry,
                getString(R.string.food_wildberry_location),
                Integer.parseInt(getString(R.string.food_wildberry_review))));

        items.add(new Item(getString(R.string.food_smoque_title),
                R.drawable.food_smoqu_bbq,
                getString(R.string.food_smoque_location),
                Integer.parseInt(getString(R.string.food_smoque_review))));

        items.add(new Item(getString(R.string.food_bohemian_title),
                R.drawable.food_bohemian_house,
                getString(R.string.food_bohemian_location),
                Integer.parseInt(getString(R.string.food_bohemian_review))));

        //Create an ItemAdapter
        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        //Get list view
        ListView listView = rootView.findViewById(R.id.list);

        //Bind with adapter
        listView.setAdapter(adapter);

        //Create a onClickLIstener when listview item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get current item index
                Item currentItem = items.get(i);

                //Create an Intent
                Intent itemDetailIntent = new Intent(getContext(), ItemDetail.class);

                //Add an extra var; ITEM_TITEL so we can reference in the ItemDetail activity
                itemDetailIntent.putExtra("ITEM_TITLE", currentItem.getTitle());

                //Start the intent
                startActivity(itemDetailIntent);
            }
        });

        //Return the view
        return rootView;
    }

}