package com.example.supremecommunityapp.ui.productList;


import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.model.supreme.MobileStock;

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

    public MobileStock test;


    @Inject
    public ProductListPresenter(SupremeCommunityApi supremeCommunityApi, ProductListContract.View view){
        this.supremeCommunityApi = supremeCommunityApi;
        this.view = view;
    }

    @Override
    public void loadData() {

        DisposableSingleObserver<MobileStock> mobileStockObservable = new DisposableSingleObserver<MobileStock>() {
            @Override
            public void onSuccess(MobileStock mobileStock) {
                Timber.d("onSuccessMethod");
                view.updateAdapter(mobileStock);
                test = mobileStock;
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("onErrorMethod");
                test = new MobileStock();
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

    @Override
    public void loadDataAll() {

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
