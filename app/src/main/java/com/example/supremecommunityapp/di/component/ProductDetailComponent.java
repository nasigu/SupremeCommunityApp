package com.example.supremecommunityapp.di.component;

import com.example.supremecommunityapp.di.module.ProductDetailModule;
import com.example.supremecommunityapp.di.scopes.ProductDetailScope;
import com.example.supremecommunityapp.ui.product_detail.ProductDetailFragment;

import dagger.Component;

@Component(modules = ProductDetailModule.class, dependencies = SupremeCommunityComponent.class)
@ProductDetailScope
public interface ProductDetailComponent {
    void inject(ProductDetailFragment productDetailFragment);
}
