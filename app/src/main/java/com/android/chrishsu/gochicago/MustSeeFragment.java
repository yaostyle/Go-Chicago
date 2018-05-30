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

public class MustSeeFragment extends Fragment {
    public MustSeeFragment() {
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