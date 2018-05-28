package com.android.chrishsu.gochicago;

public class Item {

    private String mTitle;
    private int mImageResourceId;
    private String mLocation;
    private int mReviewStar;

    private String[] mHighlights;
    private String mOverview;
    private String mProvider;
    private float mPrice;

    public Item(String title, int imageResourceId, String location, int reviewStart) {
        mTitle = title;
        mImageResourceId = imageResourceId;
        mLocation = location;
        mReviewStar = reviewStart;
    }

    public Item(String title, int imageResourceId, String location, int reviewStar, String[] highlights, String overview, String provider, float price) {
        mTitle = title;
        mImageResourceId = imageResourceId;
        mLocation = location;
        mReviewStar = reviewStar;
        mHighlights = highlights;
        mOverview = overview;
        mProvider = provider;
        mPrice = price;
    }

    public String[] getHighlights() {
        return mHighlights;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getProvider() {
        return mProvider;
    }

    public float getPrice() {
        return mPrice;
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
