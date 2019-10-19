package com.example.supremecommunityapp.ui.product_detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.di.component.DaggerProductDetailComponent;
import com.example.supremecommunityapp.di.component.ProductDetailComponent;
import com.example.supremecommunityapp.di.module.ProductDetailModule;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.ui.SupremeCommunityApplication;
import com.example.supremecommunityapp.ui.helpers.ArgumentKeys;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class ProductDetailFragment extends Fragment implements ProductDetailContract.View {

    @Inject
    public ProductDetailContract.Presenter presenter;

    ImageView ivImage;
    TextView detailProductName;
    TextView detailProductDescribe;
    View view;

    @Inject
    public Picasso picasso;



    Product product;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        product = (Product)arguments.getSerializable(ArgumentKeys.PRODUCT_DETAIL_KEY);
        inject();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_detail_fragment, container, false);
        Bundle arguments = getArguments();
        product = (Product)arguments.getSerializable(ArgumentKeys.PRODUCT_DETAIL_KEY);
        bind();
        presenter.loadData();
        return view;
    }


    @Override
    public void bind(){
        ivImage = view.findViewById(R.id.ivImage);
        detailProductName = view.findViewById(R.id.detailProductName);
        detailProductDescribe = view.findViewById(R.id.detailProductDescribe);
    }

    @Override
    public void updateContent(){
        picasso.with(ivImage.getContext())
                .load(product.getImageUrlHi())
                .into(ivImage);
        detailProductName.setText(product.getName());
    }


    @Override
    public void showProgress(Boolean show) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoaded() {

    }

    @Override
    public void showError(String error) {

    }

    private void inject() {
        ProductDetailComponent productDetailComponent = DaggerProductDetailComponent.builder()
                .productDetailModule(new ProductDetailModule(this))
                .supremeCommunityComponent(SupremeCommunityApplication.getInstance(this. getActivity()).getSupremeCommunityApplicationComponent())
                .build();
        productDetailComponent.inject(this);

    }
}
