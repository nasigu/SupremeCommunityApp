package com.example.supremecommunityapp.ui.product_list;


import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.model.supreme.MobileStock;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.model.supreme.ProductsAndCategories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class ProductListPresenter implements ProductListContract.Presenter {

    public ProductListContract.View view;
    public SupremeCommunityApi supremeCommunityApi;

    private CompositeDisposable subscriptions = new CompositeDisposable();

    private List<Product> products;


    @Inject
    public ProductListPresenter(SupremeCommunityApi supremeCommunityApi, ProductListContract.View view){
        this.supremeCommunityApi = supremeCommunityApi;
        this.view = view;
    }

    @Override
    public void loadData(final int page) {

        DisposableSingleObserver<MobileStock> mobileStockObservable = new DisposableSingleObserver<MobileStock>() {
            @Override
            public void onSuccess(MobileStock mobileStock) {
                Timber.d("onSuccessMethod");

//                view.updateAdapter(new ArrayList<>(mobileStock.getProductsAndCategories().convertAllToProducts().subList(page, page + 10)));
                view.updateAdapter(mobileStock.getProductsAndCategories().convertAllToProducts());
                view.showLoaded();
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("onErrorMethod");
            }
        };

        try{
            Disposable mobileStock = supremeCommunityApi.getMobileStock()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(mobileStockObservable) ;

            subscriptions.add(mobileStock);
        }catch(Exception e){
            Timber.d(e);
        }

//            List<Product> products = getProducts().subList(page, page);


    }

    @Override
    public void loadDataAll() {
        DisposableSingleObserver<MobileStock> mobileStockObservable = new DisposableSingleObserver<MobileStock>() {
            @Override
            public void onSuccess(MobileStock mobileStock) {
                Timber.d("onSuccessMethod");
                setProducts(mobileStock.getProductsAndCategories().convertAllToProducts());
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("onErrorMethod");
            }
        };

        try{
            Disposable mobileStock = supremeCommunityApi.getMobileStock()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(mobileStockObservable) ;

            subscriptions.add(mobileStock);
        }catch(Exception e){
            Timber.d(e);
        }
    }

    private void setProducts(List<Product> products){
        this.products = products;
    }

    private List<Product> getProducts(){
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
}
