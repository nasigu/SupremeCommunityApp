package com.example.supremecommunityapp.ui.product_list.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.ui.helpers.ScaleConverter;
import com.squareup.picasso.Picasso;


public class ProductListViewHolderNormal extends ProductListViewHolder {
    private ImageView productImage;
    private TextView productName;
    private TextView productPrice;

    private Picasso picasso;


    public ProductListViewHolderNormal(View parent, Picasso picasso) {
        super(parent, picasso);
        this.picasso = picasso;
        productName = parent.findViewById(R.id.productName);
        productPrice = parent.findViewById(R.id.productPrice);
        productImage = parent.findViewById(R.id.productImage);
    }

    @Override
    public void bind(Product product) {
        productName.setText(product.getName());
        if(product.getImageUrlHi() != ""){
            picasso.with(productImage.getContext())
                    .load(product.getImageUrlHi())
                    .into(productImage);
        }
    }

    @Override
    public void showLoading(){
        productName.setBackgroundColor(itemView.getResources().getColor(R.color.unloadItem));
        productPrice.setBackgroundColor(itemView.getResources().getColor(R.color.unloadItem));
        productName.getLayoutParams().height = (int)ScaleConverter.dpFromPx(25,itemView.getContext());
    }

    @Override
    public void showLoaded(){
        productName.setBackgroundColor(itemView.getResources().getColor(R.color.pureWhite));
        productPrice.setBackgroundColor(itemView.getResources().getColor(R.color.pureWhite));
        productName.getLayoutParams().height = (int)ScaleConverter.dpFromPx(35,itemView.getContext());
    }
}