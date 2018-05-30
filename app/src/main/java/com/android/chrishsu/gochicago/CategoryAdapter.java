package com.android.chrishsu.gochicago;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

//Create CategoryAdapter and extends from FragmentPagerAdapter
public class CategoryAdapter extends FragmentPagerAdapter {
    //Create global vars
    private Context thisContext;
    private int currentPos = -1;

    //Create CategoryAdapter constructor
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        thisContext = context;
    }

    //Override getItem method
    @Override
    public Fragment getItem(int position) {
        //Setup Fragment
        if (position == 0) { //If pos:0, create TourFragment
            currentPos = 0;
            return new TourFragment();
        } else if (position == 1) { //If pos:1, create FoodFragment
            currentPos = 1;
            return new FoodFragment();
        } else if (position == 2) { //If pos:2, create HotelFragment
            currentPos = 2;
            return new HotelFragment();
        } else { //If pos:3, create MustSeeFragment
            currentPos = 3;
            return new MustSeeFragment();
        }
    }

    //Override getCount method and return total of 4 (fragments)
    @Override
    public int getCount() {
        return 4;
    }

    //Override getPageTitle method
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) { //When pos:0, return City Tour title
            return thisContext.getString(R.string.category_name_tour);
        } else if (position == 1) { //When pos:1, return Food title
            return thisContext.getString(R.string.category_name_food);
        } else if (position == 2) { //When pos:2, return Hotel title
            return thisContext.getString(R.string.category_name_hotel);
        } else if (position == 3) { //When pos:3, return MustSee title
            return thisContext.getString(R.string.category_name_mustsee);
        } else {
            return "";
        }
    }

}
