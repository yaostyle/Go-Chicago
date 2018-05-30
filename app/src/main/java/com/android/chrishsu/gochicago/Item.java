package com.android.chrishsu.gochicago;

//Create Item class
public class Item {
    //Init private vars
    private String mTitle;
    private int mImageResourceId;
    private String mLocation;
    private int mReviewStar;

    private String[] mHighlights;
    private String mOverview;
    private String mProvider;
    private float mPrice;

    //Item constructor takes 4 params
    public Item(String title, int imageResourceId, String location, int reviewStart) {
        mTitle = title;
        mImageResourceId = imageResourceId;
        mLocation = location;
        mReviewStar = reviewStart;
    }

    //Item constructor takes 8 params
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

    //Getter for Hightlights
    public String[] getHighlights() {
        return mHighlights;
    }

    //Getter for Overview
    public String getOverview() {
        return mOverview;
    }

    //Getter for Provider
    public String getProvider() {
        return mProvider;
    }

    //Getter for Price
    public float getPrice() {
        return mPrice;
    }

    //Getter for Title
    public String getTitle() {
        return mTitle;
    }

    //Getter for ImageResource
    public int getImageResourceId() {
        return mImageResourceId;
    }

    //Getter for Location
    public String getLocation() {
        return mLocation;
    }

    //Getter for ReviewStars
    public int getReviewStar() {
        return mReviewStar;
    }

}
