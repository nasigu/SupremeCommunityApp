package com.example.supremecommunityapp.ui.productList.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.model.supreme.Shirt;

import butterknife.BindView;
import butterknife.ButterKnife;

//@AutoFactory(implementing = ProductListViewHolderFactory.class)
public class ProductListViewHolderNormal extends ProductListViewHolder {
//    @BindView(R.id.productImage)
//    ImageView productImage;
    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.productPrice)
    TextView productPrice;

    public ProductListViewHolderNormal(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_recyclerview, parent, false));
        ButterKnife.bind(this, parent);
    }

    @Override
    public void bind(Product product) {
        productName.setText(product.getName());
    }
}
