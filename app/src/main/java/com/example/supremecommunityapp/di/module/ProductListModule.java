package com.example.supremecommunityapp.di.module;

import com.example.supremecommunityapp.di.scopes.ProductListScope;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.ui.product_list.ProductListContract;
import com.example.supremecommunityapp.ui.product_list.ProductListPresenter;
import com.example.supremecommunityapp.ui.product_list.adapter.ProductListAdapter;
import com.example.supremecommunityapp.ui.product_list.adapter.ProductListViewHolderFactory;
import com.example.supremecommunityapp.ui.product_list.adapter.factory.ProductListViewHolderNormalFactory;
import com.squareup.picasso.Picasso;


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

//    @Provides
//    @ProductListScope
//
//    LinearLayoutManager provideLinearLayoutManager(ProductListContract.View productListFragment) {
//        return new LinearLayoutManager(productListFragment.getContext());
//    }


    @Provides
    @ProductListScope
    ProductListAdapter provideProductListAdapter(ProductListContract.View productListContract, ProductListViewHolderFactory productListViewHolderFactory, Picasso picasso) {
        return new ProductListAdapter(productListContract, productListViewHolderFactory, picasso);
    }

    @Provides
    @ProductListScope
    ProductListViewHolderFactory provideViewHolderNormal() {
        return new ProductListViewHolderNormalFactory();
    }

}
