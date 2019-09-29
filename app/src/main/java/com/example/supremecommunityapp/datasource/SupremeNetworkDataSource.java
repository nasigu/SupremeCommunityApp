package com.example.supremecommunityapp.datasource;

import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.model.supreme.MobileStock;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class SupremeNetworkDataSource {


    private SupremeCommunityApi api;

    private MobileStock stock;

    public SupremeNetworkDataSource(SupremeCommunityApi api){
        this.api = api;
    }

    public Disposable getSupremeMobileStock() {

        DisposableSingleObserver<MobileStock> mobileStockObservable = new DisposableSingleObserver<MobileStock>() {
            @Override
            public void onSuccess(MobileStock mobileStock) {
                Timber.d("onSuccessMethod");
                stock = mobileStock;
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("onErrorMethod");
            }
        };

        try{
            Disposable mobileStock = api.getMobileStock()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(mobileStockObservable) ;

            return mobileStock;
        }catch(Exception e){
            Timber.d(e);
            return null;
        }

    }

}
