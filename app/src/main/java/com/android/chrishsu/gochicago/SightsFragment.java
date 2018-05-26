package com.android.chrishsu.gochicago;

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

public class SightsFragment extends Fragment {

    public SightsFragment() {
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
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                1));
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                2));
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                3));
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                4));
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                5));
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                5));
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                5));
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                0));

        ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
