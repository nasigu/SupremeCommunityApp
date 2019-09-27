package com.example.supremecommunityapp.di.module;

import com.example.supremecommunityapp.ui.MainBottomBarActivity;

import dagger.Module;

@Module
public class MainBottomBarModule {
    private final MainBottomBarActivity mainBottomBarActivity;

public MainBottomBarModule(MainBottomBarActivity mainBottomBarActivity) { this.mainBottomBarActivity = mainBottomBarActivity; }


}
