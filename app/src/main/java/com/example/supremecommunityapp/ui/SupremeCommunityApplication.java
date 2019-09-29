package com.example.supremecommunityapp.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.supremecommunityapp.di.component.DaggerSupremeCommunityComponent;
import com.example.supremecommunityapp.di.component.SupremeCommunityComponent;
import com.example.supremecommunityapp.di.module.ContextModule;
import com.example.supremecommunityapp.di.module.SupremeCommunityModule;

import timber.log.Timber;

public class SupremeCommunityApplication extends Application {

    private SupremeCommunityComponent supremeCommunityApplicationComponent;

    public static SupremeCommunityApplication getInstance(Activity activity){
        return  (SupremeCommunityApplication) activity.getApplication();
    }

    public static Context getContext(){
        return SupremeCommunityApplication.getContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        supremeCommunityApplicationComponent = DaggerSupremeCommunityComponent.builder()
               .contextModule(new ContextModule(this))
               .supremeCommunityModule(new SupremeCommunityModule())
               .build();

        supremeCommunityApplicationComponent.inject(this);
    }

        public SupremeCommunityComponent getSupremeCommunityApplicationComponent(){
            return supremeCommunityApplicationComponent;
        }
    }


