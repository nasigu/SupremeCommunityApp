package com.example.supremecommunityapp.di.module;

import com.example.supremecommunityapp.di.scopes.ProductDetailScope;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.ui.product_detail.ProductDetailContract;
import com.example.supremecommunityapp.ui.product_detail.ProductDetailPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductDetailModule {
    private final ProductDetailContract.View view;

    public ProductDetailModule(ProductDetailContract.View view){
        this.view = view;
    }

    @Provides
    @ProductDetailScope
    ProductDetailContract.View provideView(){
        return view;
    }

    @Provides
    @ProductDetailScope
    ProductDetailContract.Presenter provideProductDetailPresenter(SupremeCommunityApi supremeCommunityApi, ProductDetailContract.View productDetailContract){
        return new ProductDetailPresenter(supremeCommunityApi, productDetailContract);
    }

}
