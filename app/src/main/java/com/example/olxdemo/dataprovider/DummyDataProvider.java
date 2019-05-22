package com.example.olxdemo.dataprovider;

import android.content.Context;
import android.util.Log;
import android.widget.Adapter;

import com.example.olxdemo.Model.AdProduct;
import com.example.olxdemo.Model.ProductImages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class DummyDataProvider implements DataProvider {
    Context context;

    public DummyDataProvider(Context context) {
        this.context = context;
    }

    @Override
    public void getAds(AdDataCallback callback) {
        // read json from asset text file
        // colnvert json to list of models
        // send back list of models through callback
        ArrayList<AdProduct> arrayList = readJson();
        if (arrayList.size() > 0) {
            callback.onComplete(arrayList);
        }
    }

    public ArrayList<AdProduct> readJson() {
        JSONObject jsonObject = null;

        ArrayList<AdProduct> productsList = new ArrayList<>();
        ProductImages productImages = new ProductImages();
        ArrayList<ProductImages> productImagesList = new ArrayList<>();
        if (jsonObject == null) {
            try {
                jsonObject = new JSONObject(loadJSONFromAsset());
                JSONArray productArray = jsonObject.getJSONArray("products");

                for (int i = 0; i < productArray.length(); i++) {

                    JSONObject productObject = new JSONObject();
                    AdProduct adProduct = new AdProduct();
                    productObject = productArray.getJSONObject(i);
                    adProduct.setProductPrice(productObject.getDouble("price"));
                    adProduct.setTitle(productObject.getString("title"));
                    adProduct.setAdLocation(productObject.getString("location"));
                    adProduct.setAdPostedTimeStamp(productObject.getString("timestamp"));
                    JSONArray imagesArray = productObject.getJSONArray("images");
                    for (int j = 0; j < imagesArray.length(); j++) {
                        JSONObject images = imagesArray.getJSONObject(j);
                        productImages.setUrl(images.getString("url"));
                        productImages.setMainimage(images.getBoolean("isMainImage"));
                        productImagesList.add(productImages);
                        adProduct.setProductImages(productImagesList);
                    }
                    productsList.add(adProduct);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return productsList;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("products.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
