package com.example.supremecommunityapp.ui.productList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.di.component.DaggerProductListComponent;
import com.example.supremecommunityapp.di.component.ProductListComponent;
import com.example.supremecommunityapp.di.module.ProductListModule;
import com.example.supremecommunityapp.model.supreme.MobileStock;
import com.example.supremecommunityapp.ui.productList.adapter.ProductListAdapter;
import com.example.supremecommunityapp.ui.SupremeCommunityApplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListFragment extends Fragment implements ProductListContract.View {

    @BindView(R.id.rvProductList)
    RecyclerView rvProductList;

    @Inject
    public ProductListContract.Presenter presenter;

    @Inject
    ProductListAdapter productListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        ButterKnife.bind(this.getActivity());
        setupAdapter();
        presenter.loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.product_list_fragment, container, false);
    }

    @Override
    public void showProgress(Boolean show) {

    }

    private void setupAdapter(){
        rvProductList.setAdapter(productListAdapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoaded() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateAdapter(MobileStock products) {
        productListAdapter.updateRepositoriesList(products);
    }

    private void inject() {
        ProductListComponent productListComponent = DaggerProductListComponent.builder()
                .productListModule(new ProductListModule(this))
                .supremeCommunityComponent(SupremeCommunityApplication.getInstance(this.getActivity()).getSupremeCommunityApplicationComponent())
                .build();
        productListComponent.inject(this);

    }
}
