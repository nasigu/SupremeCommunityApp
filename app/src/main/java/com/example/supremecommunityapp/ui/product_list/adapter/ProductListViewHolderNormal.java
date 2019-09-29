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
        //productPrice.setText(product.getPrice().toString().substring(0,product.getPrice().toString().length() - 2) + "$");
        if(product.getImageUrlHi() != ""){
            picasso.with(productImage.getContext())
                    .load(product.getImageUrlHi())
                    .into(productImage);
        }
        //productImage.setImageURI(Uri.parse(product.getImageUrlHi()));
    }

    @Override
    public void showLoading(){
        productName.setBackgroundColor(itemView.getResources().getColor(R.color.unloadItem));
        productPrice.setBackgroundColor(itemView.getResources().getColor(R.color.unloadItem));
//        productName.setHeight((int)ScaleConverter.dpFromPx(25,itemView.getContext()));
//        productPrice.setHeight((int)ScaleConverter.dpFromPx(25,itemView.getContext()));
        //productImage.setImageDrawable(itemView.getResources().getDrawable(R.drawable.unloaded_image));
    }

    @Override
    public void showLoaded(){
        productName.setBackgroundColor(itemView.getResources().getColor(R.color.pureWhite));
        productPrice.setBackgroundColor(itemView.getResources().getColor(R.color.pureWhite));
//        productName.setHeight((int)ScaleConverter.dpFromPx(25,itemView.getContext()));
//        productPrice.setHeight((int)ScaleConverter.dpFromPx(25,itemView.getContext()));
    }
}