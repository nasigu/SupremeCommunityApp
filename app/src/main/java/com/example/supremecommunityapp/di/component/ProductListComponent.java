package com.example.supremecommunityapp.di.component;

import com.example.supremecommunityapp.di.module.ProductListModule;
import com.example.supremecommunityapp.di.module.product_list.ProductListPresenterModule;
import com.example.supremecommunityapp.di.scopes.ProductListScope;
import com.example.supremecommunityapp.ui.product_list.ProductListFragment;
import com.example.supremecommunityapp.ui.product_list.ProductListPresenter;

import dagger.Component;

@Component(modules = ProductListModule.class,  dependencies = SupremeCommunityComponent.class)
@ProductListScope
public interface ProductListComponent {

    void inject(ProductListFragment productListFragment);

    void inject(ProductListPresenter productListPresenter);

}
