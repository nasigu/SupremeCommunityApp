package com.example.supremecommunityapp.di.component.product_list;

import com.example.supremecommunityapp.di.component.SupremeCommunityComponent;
import com.example.supremecommunityapp.di.module.product_list.ProductListPresenterModule;
import com.example.supremecommunityapp.di.scopes.ProductListScope;
import com.example.supremecommunityapp.ui.product_list.ProductListPresenter;

import dagger.Component;

@Component(modules = ProductListPresenterModule.class,  dependencies = SupremeCommunityComponent.class)
@ProductListScope
public interface ProductListPresenterComponent {

    void inject(ProductListPresenter productListPresenter);
}
