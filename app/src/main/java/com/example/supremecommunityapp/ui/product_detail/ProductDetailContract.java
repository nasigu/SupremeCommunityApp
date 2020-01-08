package com.example.supremecommunityapp.ui.product_detail;

import com.example.supremecommunityapp.model.supreme.product_detail.ProductDetail;
import com.example.supremecommunityapp.model.supreme.product_detail.ProductStyle;
import com.example.supremecommunityapp.ui.abstracts.BaseContract;

public class ProductDetailContract {

    public interface View extends BaseContract.View{
        void showProgress(Boolean show);
        void showLoading();
        void showLoaded();
        void showError(String error);
        void updateContent(ProductDetail productDetail);
        void onStyleButtonClicked(int position);

    }

    public interface Presenter extends BaseContract.Presenter<ProductDetailContract.View>{
        void loadData(int id);
    }
}
