package com.example.supremecommunityapp.ui.product_list.adapter.factory;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.supremecommunityapp.ui.product_list.adapter.ProductListViewHolderFactory;
import com.example.supremecommunityapp.ui.product_list.adapter.ProductListViewHolderNormal;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class ProductListViewHolderNormalFactory implements ProductListViewHolderFactory {

    @Inject
    public ProductListViewHolderNormalFactory(){

    }

    public ProductListViewHolderNormal create(View parent, Picasso picasso){
        return new ProductListViewHolderNormal(parent, picasso);
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(View parent, Picasso picasso) {
        return create(parent, picasso);
    }


}
