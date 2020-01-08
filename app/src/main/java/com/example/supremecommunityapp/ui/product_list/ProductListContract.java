package com.example.supremecommunityapp.ui.product_list;



import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.ui.abstracts.BaseContract;

import java.util.ArrayList;
import java.util.List;

public class ProductListContract {

    public interface View extends BaseContract.View{
        void showProgress(Boolean show);
        void showLoading();
        void showLoaded();
        void showError(String error);
        void updateAdapter(List<Product> products);
        void onProductDetailClick(Product product);
        FragmentActivity provideActivity();

    }

    public interface Presenter extends BaseContract.Presenter<View>{
        void loadData(final int page);
        void loadDataAll();

    }

}
