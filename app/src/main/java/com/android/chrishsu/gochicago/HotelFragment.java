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

//Create HotelFragment
public class HotelFragment extends Fragment {
    //Create HotelFragment constructor
    public HotelFragment() {
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
        items.add(new Item(getString(R.string.hotel_peninsula_title),
                R.drawable.hotel_the_peninsula,
                getString(R.string.hotel_peninsula_location),
                Integer.parseInt(getString(R.string.hotel_peninsula_review))));

        items.add(new Item(getString(R.string.hotel_langham_title),
                R.drawable.hotel_the_langham,
                getString(R.string.hotel_langham_location),
                Integer.parseInt(getString(R.string.hotel_langham_review))));

        items.add(new Item(getString(R.string.hotel_ace_title),
                R.drawable.hotel_ace_chicago,
                getString(R.string.hotel_ace_location),
                Integer.parseInt(getString(R.string.hotel_ace_review))));

        items.add(new Item(getString(R.string.hotel_guesthouse_title),
                R.drawable.hotel_the_guesthouse,
                getString(R.string.hotel_guesthouse_location),
                Integer.parseInt(getString(R.string.hotel_guesthouse_review))));

        items.add(new Item(getString(R.string.hotel_emc2_title),
                R.drawable.hotel_emc2,
                getString(R.string.hotel_emc2_location),
                Integer.parseInt(getString(R.string.hotel_emc2_review))));

        items.add(new Item(getString(R.string.hotel_kimption_title),
                R.drawable.hotel_kimpton,
                getString(R.string.hotel_kimption_location),
                Integer.parseInt(getString(R.string.hotel_kimption_review))));

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