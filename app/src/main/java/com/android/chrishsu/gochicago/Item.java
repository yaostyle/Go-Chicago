package com.android.chrishsu.gochicago;

//Create Item class
public class Item {
    //Init private vars
    private String itemTitle;
    private int itemImageResourceId;
    private String itemLocation;
    private int itemReviewStar;

    private String[] itemHighlights;
    private String itemOverview;
    private String itemProvider;
    private float itemPrice;

    //Item constructor takes 4 params
    public Item(String title, int imageResourceId, String location, int reviewStart) {
        itemTitle = title;
        itemImageResourceId = imageResourceId;
        itemLocation = location;
        itemReviewStar = reviewStart;
    }

    //Item constructor takes 8 params
    public Item(String title, int imageResourceId, String location, int reviewStar, String[] highlights, String overview, String provider, float price) {
        itemTitle = title;
        itemImageResourceId = imageResourceId;
        itemLocation = location;
        itemReviewStar = reviewStar;
        itemHighlights = highlights;
        itemOverview = overview;
        itemProvider = provider;
        itemPrice = price;
    }

    //Getter for Hightlights
    public String[] getHighlights() {
        return itemHighlights;
    }

    //Getter for Overview
    public String getOverview() {
        return itemOverview;
    }

    //Getter for Provider
    public String getProvider() {
        return itemProvider;
    }

    //Getter for Price
    public float getPrice() {
        return itemPrice;
    }

    //Getter for Title
    public String getTitle() {
        return itemTitle;
    }

    //Getter for ImageResource
    public int getImageResourceId() {
        return itemImageResourceId;
    }

    //Getter for Location
    public String getLocation() {
        return itemLocation;
    }

    //Getter for ReviewStars
    public int getReviewStar() {
        return itemReviewStar;
    }

}
