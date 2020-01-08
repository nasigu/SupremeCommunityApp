package com.example.supremecommunityapp.repository;

import com.example.supremecommunityapp.model.supreme.Product;

import java.util.List;

import io.reactivex.Single;

public interface ProductListNetworkRepository {

    Single<List<Product>> fetchAllProducts();

    Single<List<Product>> fetchProductsByPage(final int page);

    void retry();

    void refresh();

}
