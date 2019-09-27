package com.example.supremecommunityapp.ui.productList.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


public interface ProductListViewHolderFactory {
    RecyclerView.ViewHolder createViewHolder(ViewGroup parent);
}