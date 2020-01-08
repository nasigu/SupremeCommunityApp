package com.example.supremecommunityapp.ui.product_detail.adapter;


import android.view.View;
import android.widget.ImageView;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.model.supreme.product_detail.ProductStyle;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ProductDetailStylePreviewViewHolderNormal extends ProductDetailStylePreviewViewHolder {

    private ImageView stylePreviewImage;

    public ProductDetailStylePreviewViewHolderNormal(View itemView) {
        super(itemView);
        stylePreviewImage = itemView.findViewById(R.id.style_preview_image);
    }

    @Override
    public void bind(ProductStyle productStyle) {
//        if(!productStyle.getSwatchUrlHi().equals("")){
//            Picasso.with(stylePreviewImage.getContext())
//                    .load(productStyle.getSwatchUrl())
//                    .into(stylePreviewImage);
//        }
        // Работает медленее(
        if(!productStyle.getImageUrl().equals("")){
            Picasso.with(stylePreviewImage.getContext())
                    .load(productStyle.getSwatchUrl()) // thumbnail url goes here
                    .into(stylePreviewImage, new Callback() {
                        @Override
                        public void onSuccess() {
                            Picasso.with(stylePreviewImage.getContext())
                                    .load(productStyle.getImageUrl()) // image url goes here
                                    //.placeholder(stylePreviewImage.getDrawable())
                                    .into(stylePreviewImage);
                        }
                        @Override
                        public void onError() {

                        }
                    });
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoaded() {

    }
}
