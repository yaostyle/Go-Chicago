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

//Create TourFragment
public class TourFragment extends Fragment {
    //Create TourFragment constructor
    public TourFragment() {
        //empty constructor
    }

    //Override onStart method
    @Override
    public void onStop() {
        super.onStop();
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
        items.add(new Item(getString(R.string.tour_chicago_architecture_title),
                R.drawable.sights_chicago_architecture_tour,
                getString(R.string.tour_chicago_architecture_location),
                Integer.parseInt(getString(R.string.tour_chicago_architecture_review))));

        items.add(new Item(getString(R.string.tour_millennium_park_title),
                R.drawable.sights_millennium_park,
                getString(R.string.tour_millennium_park_location),
                Integer.parseInt(getString(R.string.tour_millennium_park_review))));

        items.add(new Item(getString(R.string.tour_navy_pier_title),
                R.drawable.sights_navy_pier,
                getString(R.string.tour_navy_pier_location),
                Integer.parseInt(getString(R.string.tour_navy_pier_review))));

        items.add(new Item(getString(R.string.tour_skydeck_title),
                R.drawable.sights_skydeck,
                getString(R.string.tour_skydeck_location),
                Integer.parseInt(getString(R.string.tour_skydeck_review))));

        items.add(new Item(getString(R.string.tour_riverwalk_title),
                R.drawable.sights_riverwalk,
                getString(R.string.tour_riverwalk_location),
                Integer.parseInt(getString(R.string.tour_riverwalk_review))));

        items.add(new Item(getString(R.string.tour_art_institute_title),
                R.drawable.sights_art_institute,
                getString(R.string.tour_art_institute_location),
                Integer.parseInt(getString(R.string.tour_art_institute_review))));

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
