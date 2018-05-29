package com.android.chrishsu.gochicago;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private int mCurrentPos = -1;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            mCurrentPos = 0;
            return new TourFragment();
        } else if (position == 1) {
            mCurrentPos = 1;
            return new FoodFragment();
        } else if (position == 2) {
            mCurrentPos = 2;
            return new HotelFragment();
        } else {
            mCurrentPos = 3;
            return new MustSeeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_name_tour);
        } else if (position == 1) {
            return mContext.getString(R.string.category_name_food);
        } else if (position == 2) {
            return mContext.getString(R.string.category_name_hotel);
        } else if (position == 3) {
            return mContext.getString(R.string.category_name_mustsee);
        } else {
            return "";
        }
    }

}
