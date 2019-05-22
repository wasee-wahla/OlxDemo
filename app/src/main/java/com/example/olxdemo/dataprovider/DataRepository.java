package com.example.olxdemo.dataprovider;

import android.content.Context;

import com.example.olxdemo.Model.AdProduct;

import java.util.ArrayList;

public class DataRepository implements DataProvider {

    private final static int MODE_DUMMY = 0;
    private final static int MODE_LIVE = 1;

    private final int MODE = MODE_DUMMY;
    Context context;
    AdDataCallback adDataCallback;
    public DataRepository(Context context) {
        this.context=context;
    }

    @Override
    public void getAds(AdDataCallback callback) {
            if (MODE==MODE_DUMMY){
                DataProvider dataProvider=new DummyDataProvider(context);
                dataProvider.getAds(callback);
            }
    }
}
