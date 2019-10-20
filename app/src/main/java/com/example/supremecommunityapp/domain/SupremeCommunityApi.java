package com.example.supremecommunityapp.domain;


import com.example.supremecommunityapp.model.supreme.MobileStock;
import com.example.supremecommunityapp.model.supreme.ProductsAndCategories;
import com.example.supremecommunityapp.model.supreme.product_detail.ProductDetail;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface SupremeCommunityApi {
    @GET("mobile_stock.json")
    Single<MobileStock> getMobileStock();

    @GET("/shop/{id}.json")
    Single<ProductDetail> getProductById(@Path("id") int id);
}
