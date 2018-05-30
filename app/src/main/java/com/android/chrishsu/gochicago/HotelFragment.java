package com.android.chrishsu.gochicago;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelFragment extends Fragment {
    public HotelFragment() {
        //empty constructor
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("The Peninsula Chicago",
                R.drawable.hotel_the_peninsula,
                "N Michigan Ave",
                5));

        items.add(new Item("The Langham, Chicago",
                R.drawable.hotel_the_langham,
                "Wabash Ave",
                5));

        items.add(new Item("Ace Hotel Chicago",
                R.drawable.hotel_ace_chicago,
                "Morgan St",
                4));

        items.add(new Item("The Guesthouse Hotel",
                R.drawable.hotel_the_guesthouse,
                "Clark St",
                5));

        items.add(new Item("Hotel EMC2, Autograph Collection",
                R.drawable.hotel_emc2,
                "Ontario St",
                4));

        items.add(new Item("Kimpton Hotel Monaco Chicago",
                R.drawable.hotel_kimpton,
                "Wabash Ave",
                3));

        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item currentItem = items.get(i);
                Intent itemDetailIntent = new Intent(getContext(), ItemDetail.class);
                itemDetailIntent.putExtra("ITEM_TITLE", currentItem.getTitle());
                startActivity(itemDetailIntent);
            }
        });

        return rootView;
    }
}