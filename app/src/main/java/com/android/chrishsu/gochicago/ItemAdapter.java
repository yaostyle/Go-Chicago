package com.android.chrishsu.gochicago;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//Create ItemAdapter
public class ItemAdapter extends ArrayAdapter<Item> {

    //ItemAdapter constructor
    public ItemAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    //Override getView method
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Get the currect view
        View listItemView = convertView;

        //If listItemView is null, inflate it from list_item
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Get the current item by position index
        Item currentItem = getItem(position);

        //Get the title TextView and set its title value
        TextView titleTextView = listItemView.findViewById(R.id.title);
        titleTextView.setText(currentItem.getTitle());

        //Get the location TextView and set its location value
        TextView locationTextView = listItemView.findViewById(R.id.location);
        locationTextView.setText(currentItem.getLocation());

        //Get the image ImageView and set its image resource ID
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentItem.getImageResourceId());

        //Call function showReviewStar and pass number of ReviewStart
        showReviewStar(listItemView, currentItem.getReviewStar());

        //Return the view
        return listItemView;
    }

    //Function to display numbers of review star
    private void showReviewStar(View listview, int star) {
        //Init all ImageView vars
        ImageView imageViewStart1 = (ImageView) listview.findViewById(R.id.review_star1);
        ImageView imageViewStart2 = (ImageView) listview.findViewById(R.id.review_star2);
        ImageView imageViewStart3 = (ImageView) listview.findViewById(R.id.review_star3);
        ImageView imageViewStart4 = (ImageView) listview.findViewById(R.id.review_star4);
        ImageView imageViewStart5 = (ImageView) listview.findViewById(R.id.review_star5);

        //Set switch statement, and assign number of filled stars
        switch (star) {
            case 1: //If 1, displays one filled star
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_border);
                imageViewStart3.setImageResource(R.drawable.ic_star_border);
                imageViewStart4.setImageResource(R.drawable.ic_star_border);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;

            case 2: //If 2, displays two filled stars
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_filled);
                imageViewStart3.setImageResource(R.drawable.ic_star_border);
                imageViewStart4.setImageResource(R.drawable.ic_star_border);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;
            case 3: //If 3, displays three filled stars
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_filled);
                imageViewStart3.setImageResource(R.drawable.ic_star_filled);
                imageViewStart4.setImageResource(R.drawable.ic_star_border);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;
            case 4: //If 4, displays four filled stars
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_filled);
                imageViewStart3.setImageResource(R.drawable.ic_star_filled);
                imageViewStart4.setImageResource(R.drawable.ic_star_filled);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;
            case 5: //If 5, displays all filled stars
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_filled);
                imageViewStart3.setImageResource(R.drawable.ic_star_filled);
                imageViewStart4.setImageResource(R.drawable.ic_star_filled);
                imageViewStart5.setImageResource(R.drawable.ic_star_filled);
                break;
            default: //Any other condition will displays bordered stars
                imageViewStart1.setImageResource(R.drawable.ic_star_border);
                imageViewStart2.setImageResource(R.drawable.ic_star_border);
                imageViewStart3.setImageResource(R.drawable.ic_star_border);
                imageViewStart4.setImageResource(R.drawable.ic_star_border);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;
        }
    }

}
