package com.example.supremecommunityapp.ui.product_list.adapter;


import android.support.v7.util.DiffUtil;

import com.example.supremecommunityapp.model.supreme.Product;

public class ProductListDiffUtil extends DiffUtil.ItemCallback<Product>{


    @Override
    public boolean areItemsTheSame(Product oldItem, Product newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(Product oldItem, Product newItem) {
        return oldItem.equals(newItem);
    }
}
