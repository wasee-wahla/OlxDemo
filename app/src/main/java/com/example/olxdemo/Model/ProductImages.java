package com.example.olxdemo.Model;

public class ProductImages {
    private String url;
    private boolean isMainimage;
    private int id;

    public ProductImages() {
    }

    public ProductImages(String url, boolean isMainimage) {
        this.url = url;
        this.isMainimage = isMainimage;
    }

    public ProductImages(String url, boolean isMainimage, int id) {
        this.url = url;
        this.isMainimage = isMainimage;
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isMainimage() {
        return isMainimage;
    }

    public void setMainimage(boolean mainimage) {
        isMainimage = mainimage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
