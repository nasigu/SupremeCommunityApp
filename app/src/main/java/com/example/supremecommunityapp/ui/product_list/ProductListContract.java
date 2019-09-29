package com.example.supremecommunityapp.ui.product_list;


import android.support.v4.app.Fragment;

import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.ui.abstracts.BaseContract;

import java.util.List;

public class ProductListContract {

    public interface View extends BaseContract.View{
        void showProgress(Boolean show);
        void showLoading();
        void showLoaded();
        void showError(String error);
        void updateAdapter(List<Product> products);
        void onProductDetailClick(Product product);

    }

    public interface Presenter extends BaseContract.Presenter<View>{
        void loadData();
        void loadDataAll();
    }

}
