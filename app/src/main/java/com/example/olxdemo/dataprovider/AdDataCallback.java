package com.example.olxdemo.dataprovider;

import com.example.olxdemo.Model.AdProduct;

import java.util.ArrayList;
import java.util.List;

public interface AdDataCallback {
    void onComplete(ArrayList<AdProduct> items);
}
