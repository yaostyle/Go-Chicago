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

//Create MustSeeFragment
public class MustSeeFragment extends Fragment {
    //Create TourFragment constructor
    public MustSeeFragment() {
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {        //First, create a rootView and inflate layout from item_listview
        //First, create a rootView and inflate layout from item_listview
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        //Create a ArrayList of Item
        final ArrayList<Item> items = new ArrayList<Item>();

        //Add list data
        items.add(new Item("Wrigley Field",
                R.drawable.mustsee_wrigley_field,
                "Addison St",
                5));

        items.add(new Item("McDonald's #1 Store Museum",
                R.drawable.mustsee_mcdonald_no1_store,
                "Addison St",
                4));

        items.add(new Item("University of Chicago",
                R.drawable.mustsee_university_of_chicago,
                "Ellis Ave",
                5));

        items.add(new Item("Chicago Loop Walking Tour",
                R.drawable.mustsee_the_loop,
                "The Loop",
                3));

        items.add(new Item("United Center",
                R.drawable.mustsee_united_center,
                "W Madison St",
                4));

        items.add(new Item("Robie House",
                R.drawable.mustsee_robie_house,
                "Woodlawn Ave",
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