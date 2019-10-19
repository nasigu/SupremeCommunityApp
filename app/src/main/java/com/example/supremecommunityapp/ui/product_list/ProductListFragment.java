package com.example.supremecommunityapp.ui.product_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.di.component.DaggerProductListComponent;
import com.example.supremecommunityapp.di.component.ProductListComponent;
import com.example.supremecommunityapp.di.module.ProductListModule;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.ui.MainBottomBarActivity;
import com.example.supremecommunityapp.ui.product_list.adapter.ProductListAdapter;
import com.example.supremecommunityapp.ui.SupremeCommunityApplication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class ProductListFragment extends Fragment implements ProductListContract.View {

    RecyclerView rvProductList;
    ProgressBar progressBar;
    View view;

    @Inject
    public ProductListContract.Presenter presenter;

    @Inject
    ProductListAdapter productListAdapter;

    GridLayoutManager gridLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void onDetailClicked(){

    }



    @Override
    public void onProductDetailClick(Product product){
       if(this.getActivity() instanceof MainBottomBarActivity){
           ((MainBottomBarActivity) this.getActivity()).startWithDetailFragment(product);
       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_list_fragment, container, false);
        bind();
        setupAdapter();
        showLoading();
        presenter.loadData();
        return view;
    }

    @Override
    public void showProgress(Boolean show) {

    }

    @Override
    public void bind(){
        rvProductList = view.findViewById(R.id.rvProductList);
        progressBar = view.findViewById(R.id.progressBar);
    }

    private void setupAdapter(){
        rvProductList.setAdapter(productListAdapter);
        gridLayoutManager = new GridLayoutManager(this.getActivity(),2);
        rvProductList.setLayoutManager(gridLayoutManager);
        List<Product> initObject = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Product product = new Product();
            product.setName("");
            product.setImageUrlHi("");
            initObject.add(product);
        }
        productListAdapter.preloadList(initObject);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoaded() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateAdapter(List<Product> products) {
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
