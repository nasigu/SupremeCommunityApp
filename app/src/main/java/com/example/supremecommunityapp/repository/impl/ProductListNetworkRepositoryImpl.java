package com.example.supremecommunityapp.repository.impl;

import android.support.annotation.NonNull;

import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.model.supreme.mapper.MobileStockMapper;
import com.example.supremecommunityapp.repository.ProductListNetworkRepository;
import com.example.supremecommunityapp.repository.mapper.ProductListMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ProductListNetworkRepositoryImpl implements ProductListNetworkRepository {

    @NonNull
    private final SupremeCommunityApi supremeCommunityApi;

    @NonNull
    private final MobileStockMapper mobileStockMapper;

    @NonNull
    private final CompositeDisposable subscription = new CompositeDisposable();

    @Inject
    public ProductListNetworkRepositoryImpl(@NonNull SupremeCommunityApi supremeCommunityApi, @NonNull MobileStockMapper mobileStockMapper) {
        this.supremeCommunityApi = supremeCommunityApi;
        this.mobileStockMapper = mobileStockMapper;
    }

    @Override
    public Single<List<Product>> fetchAllProducts() {

        return supremeCommunityApi.getMobileStock()
                .map(ProductListMapper::fromStockToProduct)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Single<List<Product>> fetchProductsByPage(final int page) {
        return supremeCommunityApi.getMobileStock()
                .map(value -> {
                    List<Product> products = ProductListMapper.fromStockToProduct(value);
                    int lastItem = products.size() < page * 10 ? products.size() : page * 10;
//                    return products.subList(((page - 1) * 10), lastItem);
                    return products.subList(0, lastItem);
//                    return products.subList(0, page * 10);
                })
                .subscribeOn(Schedulers.io());
    }

    @Override
    public void retry() {

    }

    @Override
    public void refresh() {

    }
}
