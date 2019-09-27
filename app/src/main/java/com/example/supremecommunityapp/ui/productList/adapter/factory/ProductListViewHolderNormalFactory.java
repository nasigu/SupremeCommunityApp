package com.example.supremecommunityapp.ui.productList.adapter.factory;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.supremecommunityapp.ui.productList.adapter.ProductListViewHolderFactory;
import com.example.supremecommunityapp.ui.productList.adapter.ProductListViewHolderNormal;

import javax.inject.Inject;

public class ProductListViewHolderNormalFactory implements ProductListViewHolderFactory {

    @Inject
    public ProductListViewHolderNormalFactory(){

    }

    public ProductListViewHolderNormal create(android.view.ViewGroup parent){
        return new ProductListViewHolderNormal(parent);
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        return create(parent);
    }


}
