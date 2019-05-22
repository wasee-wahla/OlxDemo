package com.example.olxdemo.Model;

import java.util.ArrayList;

public class AdProduct {
    private ArrayList<ProductImages> productImages;
    private double productPrice;
    private String title;
    private String adLocation;
    private String adPostedTimeStamp;
    private int id;

    public AdProduct() {
    }

    public AdProduct(ArrayList<ProductImages> productImages, double productPrice, String title, String adLocation, String adPostedTimeStamp) {
        this.productImages = productImages;
        this.productPrice = productPrice;
        this.title = title;
        this.adLocation = adLocation;
        this.adPostedTimeStamp = adPostedTimeStamp;
    }

    public AdProduct(ArrayList<ProductImages> productImages, double productPrice, String title, String adLocation, String adPostedTimeStamp, int id) {
        this.productImages = productImages;
        this.productPrice = productPrice;
        this.title = title;
        this.adLocation = adLocation;
        this.adPostedTimeStamp = adPostedTimeStamp;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ProductImages> getProductImages() {
        return productImages;
    }

    public void setProductImages(ArrayList<ProductImages> productImages) {
        this.productImages = productImages;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getAdLocation() {
        return adLocation;
    }

    public void setAdLocation(String adLocation) {
        this.adLocation = adLocation;
    }

    public String getAdPostedTimeStamp() {
        return adPostedTimeStamp;
    }

    public void setAdPostedTimeStamp(String adPostedTimeStamp) {
        this.adPostedTimeStamp = adPostedTimeStamp;
    }
}
