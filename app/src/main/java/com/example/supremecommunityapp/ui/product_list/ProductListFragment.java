package com.example.supremecommunityapp.ui.product_list;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.di.component.DaggerProductListComponent;
import com.example.supremecommunityapp.di.component.ProductListComponent;
import com.example.supremecommunityapp.di.module.ProductListModule;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.ui.MainBottomBarActivity;
import com.example.supremecommunityapp.ui.product_list.adapter.ProductListAdapter;
import com.example.supremecommunityapp.ui.SupremeCommunityApplication;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;


public class ProductListFragment extends Fragment implements ProductListContract.View,  SwipeRefreshLayout.OnRefreshListener {

    RecyclerView rvProductList;
    ProgressBar progressBarTop;
    ProgressBar progressBarBottom;
    View errorBlock;
    SwipeRefreshLayout swipeRefreshLayout;

    View view;

    List<Product> productList;

    private final String PRODUCT_KEY = "PRODUCT_KEY";
    private final String BUNDLE_RECYCLER_LAYOUT = "BUNDLE_RECYCLER_LAYOUT";

    private int pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 10;

    private boolean isLoading = true;
    private int visibleItemCount, totalItemCount, firstVisibleItem, previousTotal = 0;

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
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_list_fragment, container, false);
        bind();
        setupAdapter();
        setUpLoadMoreListener();
        showLoading();
        setSwipeToRefresh(view);
        presenter.loadData(1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onProductDetailClick(Product product) {
        if (this.getActivity() instanceof MainBottomBarActivity) {
            ((MainBottomBarActivity) this.getActivity()).startWithDetailFragment(product);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            productList = savedInstanceState.getParcelableArrayList(PRODUCT_KEY);
            rvProductList = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
        }
    }

    private void setUpLoadMoreListener() {
        rvProductList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView,
                                   int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = gridLayoutManager.getChildCount();
                totalItemCount = gridLayoutManager.getItemCount();
                firstVisibleItem = gridLayoutManager.findFirstVisibleItemPosition();

                if(dy > 0){

                    if(isLoading){
                        if(totalItemCount > previousTotal){
                            isLoading = false;
                            progressBarBottom.setVisibility(View.GONE);
                            previousTotal = totalItemCount;

                        }
                    }

                    if(!isLoading && (firstVisibleItem + VISIBLE_THRESHOLD) >= (totalItemCount - visibleItemCount)){
                        pageNumber++;
                        if(gridLayoutManager.findLastVisibleItemPosition() == productList.size() - 1){
                            final Handler handler = new Handler();
                            progressBarBottom.setVisibility(View.VISIBLE);
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    presenter.loadData(pageNumber);
                                    isLoading = true;
                                }
                            }, 3000);
//                        presenter.loadData(pageNumber);
//                        isLoading = true;
                        }
                    }
                }
            }
        });
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putParcelableArrayList(PRODUCT_KEY, productList);
//        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, rvProductList.getLayoutManager().onSaveInstanceState());
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        onSaveInstanceState(new Bundle());
//    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }

    @Override
    public void showProgress(Boolean show) {

    }

    private void setSwipeToRefresh(View rootView){
        swipeRefreshLayout = rootView.findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        swipeRefreshLayout.post(() -> {

            swipeRefreshLayout.setRefreshing(true);

            // Fetching data from server
            //presenter.loadDataAll();

        });
    }

    @Override
    public void onRefresh() {
        presenter.loadDataAll();
    }

    @Override
    public void bind() {
        rvProductList = view.findViewById(R.id.rvProductList);
        progressBarTop = view.findViewById(R.id.progressBarTop);
        progressBarBottom = view.findViewById(R.id.progressBarBottom);
        errorBlock = view.findViewById(R.id.errorBlock);
    }

    private void setupAdapter() {
        rvProductList.setAdapter(productListAdapter);
        gridLayoutManager = new GridLayoutManager(this.getActivity(), 2);
        rvProductList.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void showLoading() {
        progressBarTop.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoaded() {
        progressBarTop.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
        errorBlock.setVisibility(View.GONE);
        rvProductList.setVisibility(View.VISIBLE);
        progressBarBottom.setVisibility(View.GONE);

    }

    @Override
    public void showError(String error) {
        Timber.d(error);
        progressBarTop.setVisibility(View.GONE);
        errorBlock.setVisibility(View.VISIBLE);
        rvProductList.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateAdapter(List<Product> products) {
        productList = products;
        productListAdapter.updateRepositoriesList(productList);
        showLoaded();
    }

    @Override
    public FragmentActivity provideActivity(){
        return this.getActivity();
    }


    private void inject() {
        ProductListComponent productListComponent = DaggerProductListComponent.builder()
                .productListModule(new ProductListModule(this))
                .supremeCommunityComponent(SupremeCommunityApplication.getInstance(this.getActivity()).getSupremeCommunityApplicationComponent())
                .build();
        productListComponent.inject(this);
    }


}
