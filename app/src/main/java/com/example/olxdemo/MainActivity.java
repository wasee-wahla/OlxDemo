package com.example.olxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.olxdemo.Model.AdProduct;
import com.example.olxdemo.dataprovider.AdDataCallback;
import com.example.olxdemo.dataprovider.DataProvider;
import com.example.olxdemo.dataprovider.DataRepository;
import com.example.olxdemo.dataprovider.DummyDataProvider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdDataCallback {
    Button buttonSwitchRecycler;
    DataRepository dataRepository;
    AdDataCallback adDataCallback;
    RecyclerView recyclerView;
    ArrayList<AdProduct> arrayList;
    ProductAdapter productAdapter;
    public static final int LINEAR=1;
    public static final int GRID=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSwitchRecycler = findViewById(R.id.switchrecyclerlayout_btn);
        recyclerView = findViewById(R.id.item_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //recyclerView.setLayoutManager(linearLayoutManager);
        dataRepository = new DataRepository(getApplicationContext());
        dataRepository.getAds(this);
        productAdapter = new ProductAdapter(arrayList,LINEAR);
        recyclerView.setAdapter(productAdapter);
        buttonSwitchRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (productAdapter.layoutSet==GRID){
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                productAdapter = new ProductAdapter(arrayList,LINEAR);
                recyclerView.setAdapter(productAdapter);
            }else if (productAdapter.layoutSet==LINEAR){
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                productAdapter = new ProductAdapter(arrayList,GRID);
                recyclerView.setAdapter(productAdapter);
            }
            }
        });

    }


    @Override
    public void onComplete(ArrayList<AdProduct> items) {
        Log.d("size", "" + items.size());
        arrayList = items;
        Log.d("list", arrayList + "");
    }
}
