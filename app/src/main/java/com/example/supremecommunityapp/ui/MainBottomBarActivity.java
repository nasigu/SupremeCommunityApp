package com.example.supremecommunityapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.di.component.DaggerMainBottomBarComponent;
import com.example.supremecommunityapp.di.component.MainBottomBarComponent;
import com.example.supremecommunityapp.di.module.MainBottomBarModule;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.ui.helpers.ArgumentKeys;
import com.example.supremecommunityapp.ui.product_detail.ProductDetailFragment;
import com.example.supremecommunityapp.ui.product_list.ProductListFragment;

import javax.inject.Inject;

public class MainBottomBarActivity extends AppCompatActivity {

    @Inject
    ProductListFragment productListFragment;

    @Inject
    ProductDetailFragment productDetailFragment;

    @Inject
    SupremeCommunityApi supremeCommunityApi;

    FrameLayout mainContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
        inject();
        initFragment();
    }

    private void bind(){
        mainContainer = findViewById(R.id.mainActivityContainer);
    }

    private void initFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainActivityContainer, productListFragment)
                .commit();
    }

    public void startWithDetailFragment(Product product){
        Bundle arguments = new Bundle();
        arguments.putSerializable(ArgumentKeys.PRODUCT_DETAIL_KEY, product);
        productDetailFragment.setArguments(arguments);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivityContainer, productDetailFragment)
                .addToBackStack(null)
                .commit();
    }


    private void inject(){
        MainBottomBarComponent mainBottomBarComponent = DaggerMainBottomBarComponent.builder()
            .mainBottomBarModule(new MainBottomBarModule(this))
            .supremeCommunityComponent(SupremeCommunityApplication.getInstance(this).getSupremeCommunityApplicationComponent())
            .build();
        mainBottomBarComponent.inject(this);
    }

}
