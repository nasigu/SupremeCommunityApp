package com.example.supremecommunityapp.domain;


import com.example.supremecommunityapp.model.supreme.MobileStock;
import com.example.supremecommunityapp.model.supreme.ProductsAndCategories;


import io.reactivex.Single;
import retrofit2.http.GET;


public interface SupremeCommunityApi {
    @GET("mobile_stock.json")
    Single<MobileStock> getMobileStock();

    @GET("mobile_stock.json")
    Single<MobileStock> getProductById();
}
