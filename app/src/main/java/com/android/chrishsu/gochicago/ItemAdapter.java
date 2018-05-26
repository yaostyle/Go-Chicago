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

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Context context, ArrayList<Item> items) {
        super(context, 0 , items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Item currentItem = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.title);
        titleTextView.setText(currentItem.getTitle());

        TextView locationTextView = listItemView.findViewById(R.id.location);
        locationTextView.setText(currentItem.getLocation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentItem.getImageResourceId());

        showReviewStar(listItemView, currentItem.getReviewStar());

        return listItemView;
    }

    private void showReviewStar(View listview, int star){
        ImageView imageViewStart1 = (ImageView) listview.findViewById(R.id.review_star1);
        ImageView imageViewStart2 = (ImageView) listview.findViewById(R.id.review_star2);
        ImageView imageViewStart3 = (ImageView) listview.findViewById(R.id.review_star3);
        ImageView imageViewStart4 = (ImageView) listview.findViewById(R.id.review_star4);
        ImageView imageViewStart5 = (ImageView) listview.findViewById(R.id.review_star5);

        switch (star) {
            case 1:
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_border);
                imageViewStart3.setImageResource(R.drawable.ic_star_border);
                imageViewStart4.setImageResource(R.drawable.ic_star_border);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;
            case 2:
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_filled);
                imageViewStart3.setImageResource(R.drawable.ic_star_border);
                imageViewStart4.setImageResource(R.drawable.ic_star_border);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;
            case 3:
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_filled);
                imageViewStart3.setImageResource(R.drawable.ic_star_filled);
                imageViewStart4.setImageResource(R.drawable.ic_star_border);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;
            case 4:
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_filled);
                imageViewStart3.setImageResource(R.drawable.ic_star_filled);
                imageViewStart4.setImageResource(R.drawable.ic_star_filled);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;
            case 5:
                imageViewStart1.setImageResource(R.drawable.ic_star_filled);
                imageViewStart2.setImageResource(R.drawable.ic_star_filled);
                imageViewStart3.setImageResource(R.drawable.ic_star_filled);
                imageViewStart4.setImageResource(R.drawable.ic_star_filled);
                imageViewStart5.setImageResource(R.drawable.ic_star_filled);
                break;
            default:
                imageViewStart1.setImageResource(R.drawable.ic_star_border);
                imageViewStart2.setImageResource(R.drawable.ic_star_border);
                imageViewStart3.setImageResource(R.drawable.ic_star_border);
                imageViewStart4.setImageResource(R.drawable.ic_star_border);
                imageViewStart5.setImageResource(R.drawable.ic_star_border);
                break;
        }
    }

}
