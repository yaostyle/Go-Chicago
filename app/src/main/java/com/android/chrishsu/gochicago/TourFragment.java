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
import android.widget.Toast;

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
        items.add(new Item("Chicago Architecture River Cruise",
                R.drawable.sights_chicago_architecture_tour,
                "Michigan Ave",
                5));
        items.add(new Item("Millennium Park",
                R.drawable.sights_millennium_park,
                "Michigan Ave",
                5));
        items.add(new Item("Navy Pier",
                R.drawable.sights_navy_pier,
                "E Grand Ave",
                5));
        items.add(new Item("Skydeck Chicago Admission",
                R.drawable.sights_skydeck,
                "Wacker Drive",
                4));
        items.add(new Item("History and Riverwalk Tour",
                R.drawable.sights_riverwalk,
                "Michigan Ave",
                5));
        items.add(new Item("The Art Institute of Chicago",
                R.drawable.sights_art_institute,
                "Grant Park",
                4));

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
