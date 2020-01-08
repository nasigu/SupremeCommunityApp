package com.example.supremecommunityapp.ui.product_detail.adapter.factory;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.supremecommunityapp.ui.product_detail.adapter.ProductDetailStylePreviewViewHolderFactory;
import com.example.supremecommunityapp.ui.product_detail.adapter.ProductDetailStylePreviewViewHolderNormal;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class ProductDetailStylePreviewViewHolderNormalFactory implements ProductDetailStylePreviewViewHolderFactory {

    @Inject
    public ProductDetailStylePreviewViewHolderNormalFactory(){

    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(View parent) {
        return create(parent);
    }

    private ProductDetailStylePreviewViewHolderNormal create(View parent){
        return new ProductDetailStylePreviewViewHolderNormal(parent);
    }
}
