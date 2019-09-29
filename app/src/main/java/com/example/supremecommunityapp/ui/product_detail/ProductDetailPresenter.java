package com.example.supremecommunityapp.ui.product_detail;

import com.example.supremecommunityapp.domain.SupremeCommunityApi;

import javax.inject.Inject;

public class ProductDetailPresenter implements ProductDetailContract.Presenter {

    public ProductDetailContract.View view;
    public SupremeCommunityApi supremeCommunityApi;

    @Inject
    public ProductDetailPresenter(SupremeCommunityApi supremeCommunityApi, ProductDetailContract.View view){
        this.supremeCommunityApi = supremeCommunityApi;
        this.view = view;
    }

    @Override
    public void loadData() {
        view.updateContent();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void attach(ProductDetailContract.View view) {

    }
}
