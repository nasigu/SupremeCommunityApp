package com.example.supremecommunityapp.ui;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.di.component.DaggerMainBottomBarComponent;
import com.example.supremecommunityapp.di.component.MainBottomBarComponent;
import com.example.supremecommunityapp.di.module.MainBottomBarModule;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainBottomBarActivity extends AppCompatActivity {

//    RecyclerView recyclerView;

//    Picasso picasso;
    @BindView(R.id.navigationView)
    BottomNavigationView bottomNavigationView;

    @Inject
    SupremeCommunityApi supremeCommunityApi;

//    @Inject
//    ProductListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inject();
        ButterKnife.bind(this);
    }

    private void inject(){
        MainBottomBarComponent mainBottomBarComponent = DaggerMainBottomBarComponent.builder()
            .mainBottomBarModule(new MainBottomBarModule(this))
            .supremeCommunityComponent(SupremeCommunityApplication.getInstance(this).getSupremeCommunityApplicationComponent())
            .build();
        mainBottomBarComponent.inject(this);
    }

}
