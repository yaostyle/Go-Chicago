package com.android.chrishsu.gochicago;

public class Item {

    private String mTitle;
    private int mImageResourceId;
    private String mLocation;

    public Item(String title, int imageResourceId, String location) {
        mTitle = title;
        mImageResourceId = imageResourceId;
        mLocation = location;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getLocation() {
        return mLocation;
    }
}
