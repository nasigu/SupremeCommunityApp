package com.example.supremecommunityapp.di.component;

import com.example.supremecommunityapp.di.module.ProductListModule;
import com.example.supremecommunityapp.di.scopes.ProductListScope;
import com.example.supremecommunityapp.ui.productList.ProductListFragment;

import dagger.Component;

@Component(modules = ProductListModule.class, dependencies = SupremeCommunityComponent.class)
@ProductListScope
public interface ProductListComponent {
    void inject(ProductListFragment productListFragment);
}
