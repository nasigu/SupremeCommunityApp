package com.example.supremecommunityapp.di.module;

import com.example.supremecommunityapp.di.scopes.MainBottomBarActivityScope;
import com.example.supremecommunityapp.ui.MainBottomBarActivity;
import com.example.supremecommunityapp.ui.product_detail.ProductDetailFragment;
import com.example.supremecommunityapp.ui.product_list.ProductListFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class MainBottomBarModule {
    private final MainBottomBarActivity mainBottomBarActivity;

public MainBottomBarModule(MainBottomBarActivity mainBottomBarActivity) { this.mainBottomBarActivity = mainBottomBarActivity; }

    @MainBottomBarActivityScope
    @Provides
    ProductListFragment proviceProductListFragment(){
        return new ProductListFragment();
    }

    @MainBottomBarActivityScope
    @Provides
    ProductDetailFragment provideProductDetailFragment(){
        return new ProductDetailFragment();
    }

}
