package com.example.supremecommunityapp.ui.product_list;


import com.example.supremecommunityapp.di.component.DaggerProductListComponent;
import com.example.supremecommunityapp.di.component.ProductListComponent;
import com.example.supremecommunityapp.di.module.ProductListModule;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.model.supreme.MobileStock;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.repository.impl.ProductListNetworkRepositoryImpl;
import com.example.supremecommunityapp.ui.SupremeCommunityApplication;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class ProductListPresenter implements ProductListContract.Presenter {

    public ProductListContract.View view;
    public SupremeCommunityApi supremeCommunityApi;

    private CompositeDisposable subscriptions = new CompositeDisposable();

    private List<Product> products;


    @Inject
    public ProductListPresenter(SupremeCommunityApi supremeCommunityApi, ProductListContract.View view) {
        this.supremeCommunityApi = supremeCommunityApi;
        this.view = view;
        inject();
    }

    @Inject
    public ProductListNetworkRepositoryImpl productListNetworkRepository;


    @Override
    public void loadData(final int page) {

        subscriptions.add(productListNetworkRepository.fetchProductsByPage(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::updateAdapter,
                           throwable -> view.showError(throwable.getMessage())
                ));


    }


    @Override
    public void loadDataAll() {
        subscriptions.add(productListNetworkRepository.fetchAllProducts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::updateAdapter,
                        throwable -> view.showError(throwable.getMessage())
                ));
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }

    private List<Product> getProducts() {
        return this.products;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        subscriptions.clear();
    }

    @Override
    public void attach(ProductListContract.View view) {

        //this.view = view;
    }


    private void inject() {
        ProductListComponent productListComponent = DaggerProductListComponent.builder()
                .productListModule(new ProductListModule(view))
                .supremeCommunityComponent(SupremeCommunityApplication.getInstance(view.provideActivity()).getSupremeCommunityApplicationComponent())
                .build();
        productListComponent.inject(this);

    }


}
