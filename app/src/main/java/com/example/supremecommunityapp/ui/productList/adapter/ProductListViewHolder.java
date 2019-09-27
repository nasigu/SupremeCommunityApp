package com.example.supremecommunityapp.ui.productList.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.supremecommunityapp.model.supreme.Product;

public abstract class ProductListViewHolder extends RecyclerView.ViewHolder  {

    public ProductListViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Product product);

}
