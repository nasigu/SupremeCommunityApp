package com.example.supremecommunityapp.ui.product_list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.squareup.picasso.Picasso;


public interface ProductListViewHolderFactory {
    RecyclerView.ViewHolder createViewHolder(View parent, Picasso picasso);


}