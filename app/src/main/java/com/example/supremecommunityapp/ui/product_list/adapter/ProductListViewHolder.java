package com.example.supremecommunityapp.ui.product_list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.supremecommunityapp.model.supreme.Product;
import com.squareup.picasso.Picasso;

public abstract class ProductListViewHolder extends RecyclerView.ViewHolder  {

    public ProductListViewHolder(View itemView, Picasso picasso) {
        super(itemView);
    }

    public abstract void bind(Product product);

    public abstract void showLoading();

    public abstract void showLoaded();

}
