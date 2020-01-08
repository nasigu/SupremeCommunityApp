package com.example.supremecommunityapp.ui.product_detail.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.model.supreme.product_detail.ProductStyle;
import com.example.supremecommunityapp.ui.product_detail.ProductDetailContract;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductDetailStylePreviewAdapter extends RecyclerView.Adapter {

    private ProductDetailContract.View productDetailView;
    private ProductDetailStylePreviewViewHolderFactory productDetailStylePreviewViewHolder;
    private Picasso picasso;

    private List<ProductStyle> productStyleList;

    public ProductDetailStylePreviewAdapter(ProductDetailContract.View productDetailView, ProductDetailStylePreviewViewHolderFactory productDetailStylePreviewViewHolderFactory, Picasso picasso){
        this.productDetailView = productDetailView;
        this.productDetailStylePreviewViewHolder = productDetailStylePreviewViewHolderFactory;
        this.picasso = picasso;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = productDetailStylePreviewViewHolder.createViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_detail_style_preview_item, parent, false));
        viewHolder.itemView.setOnClickListener(v -> onStylePreviewClicked(viewHolder.getAdapterPosition()));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ProductDetailStylePreviewViewHolder) holder).bind(productStyleList.get(position));
    }

    private void onStylePreviewClicked(int adapterPosition) {
        productDetailView.onStyleButtonClicked(adapterPosition);
    }


    @Override
    public int getItemCount() {
        if(productStyleList != null){
            return productStyleList.size();
        }
        return 0;
    }


    public void updateProductStyleList(List<ProductStyle> productStyles){
        this.productStyleList = null;
        this.productStyleList = productStyles;
        notifyDataSetChanged();
    }

}
