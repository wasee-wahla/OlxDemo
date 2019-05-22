package com.example.olxdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.olxdemo.Model.AdProduct;
import com.example.olxdemo.Model.ProductImages;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemViewHolder> {
    ArrayList<AdProduct> arrayList;
    public static final int LINEAR = 1;
    public static final int GRID = 2;
    int layoutSet;

    public ProductAdapter(ArrayList<AdProduct> arrayList, int layoutSet) {
        this.arrayList = arrayList;
        this.layoutSet = layoutSet;
    }

    @Override
    public int getItemViewType(int position) {
        if (layoutSet == LINEAR) {
            return LINEAR;
        } else {
            return GRID;
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == LINEAR) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_product_layout, viewGroup, false);
            return new ItemViewHolder(view);
        } else if (i == GRID) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_product_layout, viewGroup, false);
            return new ItemViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        AdProduct adProduct = arrayList.get(position);
        ArrayList<ProductImages> arrayListProductImages = adProduct.getProductImages();
        ProductImages productImages = arrayListProductImages.get(position);
        itemViewHolder.productPrice.setText("RS "+String.valueOf(adProduct.getProductPrice()));
        itemViewHolder.productTitle.setText(adProduct.getTitle());
        itemViewHolder.productLocation.setText(adProduct.getAdLocation());
        itemViewHolder.productTimeStamp.setText(adProduct.getAdPostedTimeStamp());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView productPrice;
        private TextView productTitle;
        private TextView productLocation;
        private TextView productTimeStamp;
        private ImageView productImage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productPrice = itemView.findViewById(R.id.productprice);
            productTitle = itemView.findViewById(R.id.producttitle);
            productLocation = itemView.findViewById(R.id.productlocation);
            productTimeStamp = itemView.findViewById(R.id.producttimestamp);
            productImage = itemView.findViewById(R.id.productimage);
        }
    }
}
