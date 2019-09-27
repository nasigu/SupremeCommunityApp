package com.example.supremecommunityapp.di.module;

import com.example.supremecommunityapp.di.scopes.ProductListScope;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.ui.productList.ProductListContract;
import com.example.supremecommunityapp.ui.productList.ProductListPresenter;
import com.example.supremecommunityapp.ui.productList.adapter.ProductListAdapter;
import com.example.supremecommunityapp.ui.productList.adapter.ProductListViewHolderFactory;
import com.example.supremecommunityapp.ui.productList.adapter.factory.ProductListViewHolderNormalFactory;


import dagger.Module;
import dagger.Provides;

@Module
public class ProductListModule {
    private final ProductListContract.View view;

    public ProductListModule(ProductListContract.View view){
        this.view = view;
    }

    @Provides
    @ProductListScope
    ProductListContract.View provideView(){
        return view;
    }

    @Provides
    @ProductListScope
    ProductListContract.Presenter getProductListPresenter(SupremeCommunityApi supremeCommunityApi, ProductListContract.View productListFragment){
        return new ProductListPresenter(supremeCommunityApi, productListFragment);
    }


    @Provides
    @ProductListScope
    ProductListAdapter provideProductListAdapter(ProductListContract.View productListContract, ProductListViewHolderFactory productListViewHolderFactory) {
        return new ProductListAdapter(productListContract, productListViewHolderFactory);
    }

    @Provides
    @ProductListScope
    ProductListViewHolderFactory provideViewHolderNormal() {
        return new ProductListViewHolderNormalFactory();
    }

}
