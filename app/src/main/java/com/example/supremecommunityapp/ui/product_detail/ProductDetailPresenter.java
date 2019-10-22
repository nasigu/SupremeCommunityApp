package com.example.supremecommunityapp.ui.product_detail;

import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.model.supreme.MobileStock;
import com.example.supremecommunityapp.model.supreme.product_detail.ProductDetail;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class ProductDetailPresenter implements ProductDetailContract.Presenter {

    public ProductDetailContract.View view;
    public SupremeCommunityApi supremeCommunityApi;

    private CompositeDisposable subscriptions = new CompositeDisposable();


    @Inject
    public ProductDetailPresenter(SupremeCommunityApi supremeCommunityApi, ProductDetailContract.View view){
        this.supremeCommunityApi = supremeCommunityApi;
        this.view = view;
    }

    @Override
    public void loadData(int id) {

        DisposableSingleObserver<ProductDetail> productDetailObservable = new DisposableSingleObserver<ProductDetail>() {
            @Override
            public void onSuccess(ProductDetail productDetail) {
                Timber.d("onSuccessMethod");
                view.updateContent(productDetail);
                view.showLoaded();
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("onErrorMethod");
            }
        };

        try{
            Disposable product = supremeCommunityApi.getProductById(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(productDetailObservable) ;

            subscriptions.add(product);
        }catch(Exception e){
            Timber.d(e);
        }

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        subscriptions.clear();
    }

    @Override
    public void attach(ProductDetailContract.View view) {

    }
}
