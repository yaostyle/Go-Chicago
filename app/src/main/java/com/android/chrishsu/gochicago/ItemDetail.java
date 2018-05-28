package com.android.chrishsu.gochicago;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ItemDetail extends AppCompatActivity {
    final ArrayList<Item> mItems = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        String item_title = getIntent().getStringExtra("ITEM_TITLE");
        setTitle(item_title);

        initItems(mItems);

        int currentItemIndex = getItemIndexByTitle(item_title);

        Log.d("title index:", String.valueOf(currentItemIndex));

    }

    public int getItemIndexByTitle(String title) {
        try {
            for (int i = 0; i < mItems.size(); i++) {
                Item currentItem = mItems.get(i);
                String currentTitle = currentItem.getTitle();
                if (title.equals(currentTitle)) {
                    return i;
                }
            }
        } catch(Error error) {
            //skip
        }
        return -1;
    }

    public void initItems(ArrayList<Item> items) {
        // final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Chicago Tour--1",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                1));
        items.add(new Item("Chicago Tour--2",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                1));
    }
}
