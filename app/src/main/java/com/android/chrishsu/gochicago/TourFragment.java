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

public class TourFragment extends Fragment {

    public TourFragment() {
        //empty constructor
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        final ArrayList<Item> items = new ArrayList<Item>();
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
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                5));
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                5));

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
