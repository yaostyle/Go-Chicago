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
        items.add(new Item(getString(R.string.mustsee_wrigley_title),
                R.drawable.mustsee_wrigley_field,
                getString(R.string.mustsee_wrigley_location),
                Integer.parseInt(getString(R.string.mustsee_wrigley_review))));

        items.add(new Item(getString(R.string.mustsee_mcdonald_title),
                R.drawable.mustsee_mcdonald_no1_store,
                getString(R.string.mustsee_mcdonald_location),
                Integer.parseInt(getString(R.string.mustsee_mcdonald_review))));

        items.add(new Item(getString(R.string.mustsee_uc_title),
                R.drawable.mustsee_university_of_chicago,
                getString(R.string.mustsee_uc_location),
                Integer.parseInt(getString(R.string.mustsee_uc_review))));

        items.add(new Item(getString(R.string.mustsee_loop_title),
                R.drawable.mustsee_the_loop,
                getString(R.string.mustsee_loop_location),
                Integer.parseInt(getString(R.string.mustsee_loop_review))));

        items.add(new Item(getString(R.string.mustsee_united_title),
                R.drawable.mustsee_united_center,
                getString(R.string.mustsee_united_location),
                Integer.parseInt(getString(R.string.mustsee_united_review))));

        items.add(new Item(getString(R.string.mustsee_robie_title),
                R.drawable.mustsee_robie_house,
                getString(R.string.mustsee_robie_location),
                Integer.parseInt(getString(R.string.mustsee_robie_review))));

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