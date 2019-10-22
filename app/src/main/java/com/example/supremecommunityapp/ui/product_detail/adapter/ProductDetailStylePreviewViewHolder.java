package com.example.supremecommunityapp.ui.product_detail.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.supremecommunityapp.model.supreme.product_detail.ProductStyle;
import com.squareup.picasso.Picasso;

public abstract class ProductDetailStylePreviewViewHolder extends RecyclerView.ViewHolder {

    public ProductDetailStylePreviewViewHolder(View itemView, Picasso picasso) {
        super(itemView);
    }

    public abstract void bind(ProductStyle productStyle);

    public abstract void showLoading();

    public abstract void showLoaded();
}
