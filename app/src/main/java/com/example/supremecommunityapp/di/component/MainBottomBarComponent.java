package com.example.supremecommunityapp.di.component;

import com.example.supremecommunityapp.di.module.MainBottomBarModule;
import com.example.supremecommunityapp.di.scopes.MainBottomBarActivityScope;
import com.example.supremecommunityapp.ui.MainBottomBarActivity;

import dagger.Component;

@Component(modules = MainBottomBarModule.class, dependencies = SupremeCommunityComponent.class)
@MainBottomBarActivityScope
public interface MainBottomBarComponent {
    void inject(MainBottomBarActivity mainBottomBarActivity);
}
