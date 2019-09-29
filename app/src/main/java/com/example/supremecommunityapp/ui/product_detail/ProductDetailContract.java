package com.example.supremecommunityapp.ui.product_detail;

import com.example.supremecommunityapp.ui.abstracts.BaseContract;

public class ProductDetailContract {

    public interface View extends BaseContract.View{
        void showProgress(Boolean show);
        void showLoading();
        void showLoaded();
        void showError(String error);
        void updateContent();

    }

    public interface Presenter extends BaseContract.Presenter<ProductDetailContract.View>{
        void loadData();
    }
}
