package com.example.supremecommunityapp.model.supreme;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobileStock {

    @SerializedName("products_and_categories")
    @Expose
    private ProductsAndCategories productsAndCategories = null;

    public ProductsAndCategories getProductsAndCategories(){
        return productsAndCategories;
    }

    public void setProductsAndCategories(ProductsAndCategories productsAndCategories){
        this.productsAndCategories = productsAndCategories;
    }
}
