package com.example.supremecommunityapp.ui.product_list.adapter;


import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.example.supremecommunityapp.model.supreme.Product;

import java.util.List;

public class ProductListDiffUtil extends DiffUtil.Callback{

    List<Product> oldProducts;
    List<Product> newProducts;

    public ProductListDiffUtil(List<Product> newProducts, List<Product> oldProducts) {
        this.newProducts = newProducts;
        this.oldProducts = oldProducts;
    }

    @Override
    public int getOldListSize() {
        return oldProducts.size();
    }

    @Override
    public int getNewListSize() {
        return newProducts.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldProducts.get(oldItemPosition).getId().equals(newProducts.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldProducts.get(oldItemPosition).equals(newProducts.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        //you can return particular field for changed item.
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
