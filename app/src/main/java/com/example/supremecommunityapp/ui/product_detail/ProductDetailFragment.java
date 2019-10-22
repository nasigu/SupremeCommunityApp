package com.example.supremecommunityapp.ui.product_detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

import javax.inject.Inject;

public class ProductDetailFragment extends Fragment implements ProductDetailContract.View {

    @Inject
    public ProductDetailContract.Presenter presenter;

    ImageView ivImage;
    TextView detailProductName;
    TextView detailProductDescribe;
    TextView detailProductPrice;
    RecyclerView rvProductDetailStylePreview;

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
        setupPreviewStylesAdapter();
        presenter.loadData(product.getId());
        return view;
    }


    @Override
    public void bind(){
        ivImage = view.findViewById(R.id.ivImage);
        detailProductName = view.findViewById(R.id.detailProductName);
        detailProductDescribe = view.findViewById(R.id.detailProductDescribe);
        detailProductPrice = view.findViewById(R.id.detailProductPrice);
        rvProductDetailStylePreview = view.findViewById(R.id.rvProductDetailStylePreview);
    }

    @Override
    public void updateContent(ProductDetail productDetail){
        picasso.with(ivImage.getContext())
                .load(productDetail.getStyles().get(0).getImageUrlHi())
                .into(ivImage);
        detailProductName.setText(product.getName());
        detailProductDescribe.setText(productDetail.getDescription());
        productDetailStylePreviewAdapter.updateProductStyleList(productDetail.getStyles());

    }

    private void setupPreviewStylesAdapter(){
        rvProductDetailStylePreview.setAdapter(productDetailStylePreviewAdapter);
        linearLayout = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvProductDetailStylePreview.setLayoutManager(linearLayout);
    }

    @Override
    public void onStyleButtonClicked(ProductStyle productStyle ){
        picasso.with(ivImage.getContext())
                .load(productStyle.getImageUrlHi())
                .into(ivImage);
    }


    @Override
    public void showProgress(Boolean show) {

    }

    @Override
    public void showLoading() {
//        detailProductName.setBackgroundColor(view.getResources().getColor(R.color.unloadItem));
//        detailProductDescribe.setBackgroundColor(view.getResources().getColor(R.color.unloadItem));
//        detailProductPrice.setBackgroundColor(view.getResources().getColor(R.color.unloadItem));
    }

    @Override
    public void showLoaded() {
        detailProductName.setBackgroundColor(view.getResources().getColor(R.color.pureWhite));
        detailProductDescribe.setBackgroundColor(view.getResources().getColor(R.color.pureWhite));
        detailProductPrice.setBackgroundColor(view.getResources().getColor(R.color.pureWhite));
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
