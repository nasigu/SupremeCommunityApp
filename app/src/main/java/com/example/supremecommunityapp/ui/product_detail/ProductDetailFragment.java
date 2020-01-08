package com.example.supremecommunityapp.ui.product_detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.support.v7.widget.LinearLayoutManager;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.di.component.DaggerProductDetailComponent;
import com.example.supremecommunityapp.di.component.ProductDetailComponent;
import com.example.supremecommunityapp.di.module.ProductDetailModule;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.model.supreme.product_detail.ProductDetail;
import com.example.supremecommunityapp.model.supreme.product_detail.ProductStyle;
import com.example.supremecommunityapp.ui.SupremeCommunityApplication;
import com.example.supremecommunityapp.ui.helpers.ArgumentKeys;
import com.example.supremecommunityapp.ui.product_detail.adapter.ProductDetailStylePreviewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProductDetailFragment extends Fragment implements ProductDetailContract.View {

    @Inject
    public ProductDetailContract.Presenter presenter;

    //ImageView ivImage;
    TextView detailProductName;
    TextView detailProductDescribe;
    TextView detailProductPrice;
    ProgressBar progressBar;
    View errorBlock;
    RecyclerView rvProductDetailStylePreview;
    ViewPager viewPager;

    View view;

    @Inject
    public Picasso picasso;

    @Inject
    ProductDetailStylePreviewAdapter productDetailStylePreviewAdapter;

    LinearLayoutManager linearLayout;

    Product product;
    ProductDetail productDetail;

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
        showLoading();
        setupAdapter();
        presenter.loadData(product.getId());
        return view;
    }


    @Override
    public void bind(){
        detailProductName = view.findViewById(R.id.detailProductName);
        detailProductDescribe = view.findViewById(R.id.detailProductDescribe);
        detailProductPrice = view.findViewById(R.id.detailProductPrice);
        rvProductDetailStylePreview = view.findViewById(R.id.rvProductDetailStylePreview);
        errorBlock = view.findViewById(R.id.errorBlock);
        progressBar = view.findViewById(R.id.progressBar);
        viewPager = view.findViewById(R.id.view_pager_slider);
    }

    @Override
    public void updateContent(ProductDetail productDetail){
        detailProductName.setText(product.getName());
        detailProductDescribe.setText(productDetail.getDescription());
        detailProductPrice.setText(String.format(getResources().getString(R.string.product_detail_price_euro_placeholder), String.valueOf(product.getPrice() / 100)));
        productDetailStylePreviewAdapter.updateProductStyleList(productDetail.getStyles());
        setupImageSlider(productDetail.getStyles());
    }

    private void setupAdapter(){
        rvProductDetailStylePreview.setAdapter(productDetailStylePreviewAdapter);
        linearLayout = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvProductDetailStylePreview.setLayoutManager(linearLayout);
    }

    private void setupImageSlider(List<ProductStyle> styles){
        viewPager.setAdapter(new ProductDetailImageSlider(this.getContext(), styles));
    }

    @Override
    public void onStyleButtonClicked(int position){
        viewPager.setCurrentItem(position);
    }


    @Override
    public void showProgress(Boolean show) {
        if(show){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLoading() {
        showProgress(true);
    }

    @Override
    public void showLoaded() {
        detailProductName.setBackgroundColor(view.getResources().getColor(R.color.pureWhite));
        detailProductDescribe.setBackgroundColor(view.getResources().getColor(R.color.pureWhite));
        detailProductPrice.setBackgroundColor(view.getResources().getColor(R.color.pureWhite));
        errorBlock.setVisibility(View.GONE);
        showProgress(false);


    }

    @Override
    public void showError(String error) {
        errorBlock.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        showProgress(false);

    }

    private void inject() {
        ProductDetailComponent productDetailComponent = DaggerProductDetailComponent.builder()
                .productDetailModule(new ProductDetailModule(this))
                .supremeCommunityComponent(SupremeCommunityApplication.getInstance(this. getActivity()).getSupremeCommunityApplicationComponent())
                .build();
        productDetailComponent.inject(this);

    }
}
