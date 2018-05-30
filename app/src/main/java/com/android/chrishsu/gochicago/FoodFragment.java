package com.android.chrishsu.gochicago;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
        items.add(new Item("Lou Malnati's Pizzeria",
                R.drawable.food_lou_malnati_pizza,
                "State St",
                5));
        items.add(new Item("Girl & The Goat",
                R.drawable.food_girl_and_the_goat,
                "Randolph St",
                5));

        items.add(new Item("Portillo's",
                R.drawable.food_portillos,
                "Ontario St",
                4));

        items.add(new Item("Wildberry Pancakes and Cafe",
                R.drawable.food_wildberry,
                "Randolph St",
                5));

        items.add(new Item("Smoque BBQ",
                R.drawable.food_smoqu_bbq,
                "Pulaski Rd",
                5));

        items.add(new Item("Bohemian House",
                R.drawable.food_bohemian_house,
                "Illinois St",
                5));

        //Create an ItemAdapter
        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        //Get list view
        ListView listView = (ListView) rootView.findViewById(R.id.list);

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