package com.example.supremecommunityapp.di.module.product_list;

import com.example.supremecommunityapp.di.scopes.ProductListScope;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.model.supreme.mapper.MobileStockMapper;
import com.example.supremecommunityapp.repository.impl.ProductListNetworkRepositoryImpl;
import com.example.supremecommunityapp.ui.product_list.ProductListContract;

import dagger.Module;
import dagger.Provides;

@Module

public class ProductListPresenterModule {

    private final ProductListContract.Presenter presenter;

    public ProductListPresenterModule(ProductListContract.Presenter presenter){
        this.presenter = presenter;
    }

    @Provides
    @ProductListScope
    ProductListContract.Presenter providePresenter(){
        return presenter;
    }

    @Provides
    @ProductListScope
    public ProductListNetworkRepositoryImpl provideUsersRepository(SupremeCommunityApi supremeCommunityApi, MobileStockMapper mobileStockMapper){
        return new ProductListNetworkRepositoryImpl(supremeCommunityApi, mobileStockMapper);
    }

    @Provides
    @ProductListScope
    public MobileStockMapper provideMobileStockMapper(){
        return new MobileStockMapper();
    }
}
