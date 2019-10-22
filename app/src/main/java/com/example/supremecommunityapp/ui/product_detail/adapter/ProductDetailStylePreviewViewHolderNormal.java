package com.example.supremecommunityapp.ui.product_detail.adapter;


import android.view.View;
import android.widget.ImageView;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.model.supreme.product_detail.ProductStyle;
import com.squareup.picasso.Picasso;

public class ProductDetailStylePreviewViewHolderNormal extends ProductDetailStylePreviewViewHolder {

    private Picasso picasso;

    private ImageView stylePreviewImage;

    public ProductDetailStylePreviewViewHolderNormal(View itemView, Picasso picasso) {
        super(itemView, picasso);
        this.picasso = picasso;
        stylePreviewImage = itemView.findViewById(R.id.style_preview_image);
    }

    @Override
    public void bind(ProductStyle productStyle) {
        if(!productStyle.getSwatchUrlHi().equals("")){
            picasso.with(stylePreviewImage.getContext())
                    .load(productStyle.getSwatchUrlHi())
                    .into(stylePreviewImage);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoaded() {

    }
}
