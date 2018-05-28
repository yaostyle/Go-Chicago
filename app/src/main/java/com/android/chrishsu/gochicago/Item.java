package com.android.chrishsu.gochicago;

public class Item {

    private String mTitle;
    private int mImageResourceId;
    private String mLocation;
    private int mReviewStar;

    public Item(String title, int imageResourceId, String location, int reviewStart) {
        mTitle = title;
        mImageResourceId = imageResourceId;
        mLocation = location;
        mReviewStar = reviewStart;
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

    public int getReviewStar() { return mReviewStar; }

}
