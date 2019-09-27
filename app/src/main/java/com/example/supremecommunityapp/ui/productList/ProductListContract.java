package com.example.supremecommunityapp.ui.productList;

import com.example.supremecommunityapp.model.supreme.MobileStock;
import com.example.supremecommunityapp.ui.abstracts.BaseContract;

public class ProductListContract {

    public interface View extends BaseContract.View{
        void showProgress(Boolean show);
        void showLoading();
        void showLoaded();
        void showError(String error);
        void updateAdapter(MobileStock products);

    }

    public interface Presenter extends BaseContract.Presenter<View>{
        void loadData();
        void loadDataAll();
    }

}
