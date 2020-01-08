package com.example.supremecommunityapp.repository.mapper;

import com.example.supremecommunityapp.domain.entity.SupremeStock;
import com.example.supremecommunityapp.model.supreme.MobileStock;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.model.supreme.ProductsAndCategories;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ProductListMapper implements Function<Product, SupremeStock> {
    @Override
    public SupremeStock apply(Product product) throws Exception {
        return null;
    }

    public static List<Product> fromStockToProduct(MobileStock mobileStock){
        List<Product> products =  new ArrayList<>();
        ProductsAndCategories productsAndCategories =  mobileStock.getProductsAndCategories();
        if(productsAndCategories.getJackets() != null)
            products.addAll(productsAndCategories.getJackets());
        if(productsAndCategories.getSweatshirts() != null)
            products.addAll(productsAndCategories.getSweatshirts());
        if(productsAndCategories.getShirts() != null)
            products.addAll(productsAndCategories.getShirts());
        if(productsAndCategories.getPants() != null)
            products.addAll(productsAndCategories.getPants());
        if(productsAndCategories.getTopsSweaters() != null)
            products.addAll(productsAndCategories.getTopsSweaters());
        if(productsAndCategories.getTShirts() != null)
            products.addAll(productsAndCategories.getTShirts());
        if(productsAndCategories.getBags() != null)
            products.addAll(productsAndCategories.getBags());
        if(productsAndCategories.getAccessories() != null)
            products.addAll(productsAndCategories.getAccessories());
        if(productsAndCategories.getSkate() != null)
            products.addAll(productsAndCategories.getSkate());
        if(productsAndCategories.getHats() != null)
            products.addAll(productsAndCategories.getHats());
        if(productsAndCategories.getNew() != null)
            products.addAll(productsAndCategories.getNew());
        return products;
    }

}
