package com.android.chrishsu.gochicago;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

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

        ImageView itemImage = (ImageView) findViewById(R.id.item_image);
        itemImage.setImageResource(mItems.get(currentItemIndex).getImageResourceId());

        TextView itemTitle = (TextView) findViewById(R.id.item_title);
        itemTitle.setText(mItems.get(currentItemIndex).getTitle());

        TextView itemLocation = (TextView) findViewById(R.id.item_location);
        itemLocation.setText(mItems.get(currentItemIndex).getLocation());

        TextView itemHighlight = (TextView) findViewById(R.id.item_hightlights);
        String[] highlights = mItems.get(currentItemIndex).getHighlights();
        String highlights_text = "";

        for (int i=0; i < highlights.length; i++) {
            highlights_text += highlights[i] + "\n";
        }
        itemHighlight.setText(highlights_text);

        TextView itemOverview = (TextView) findViewById(R.id.item_overview);
        itemOverview.setText(mItems.get(currentItemIndex).getOverview());

        TextView itemPrice = (TextView) findViewById(R.id.item_price);
        itemPrice.setText(String.valueOf(mItems.get(currentItemIndex).getPrice()));

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
            //skip error checking
        }
        return -1;
    }

    private void initItems(ArrayList<Item> items) {
        // final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Chicago Tour",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                5,
                new String[] {"list1", "list2"},
                "overview",
                "provider",
                (float) 43.68));

        items.add(new Item("Chicago Tour2",
                R.drawable.sights_chicago_architecture_tour,
                "Chicago Downtown",
                5,
                new String[] {"list1", "list2"},
                "overview",
                "provider",
                (float) 43.68));

    }
}
