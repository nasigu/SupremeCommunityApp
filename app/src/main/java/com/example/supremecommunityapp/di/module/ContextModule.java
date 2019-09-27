package com.example.supremecommunityapp.di.module;

import android.content.Context;

import com.example.supremecommunityapp.di.qualifiers.ApplicationContext;
import com.example.supremecommunityapp.di.scopes.SupremeCommunityApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) { this.context = context; }

    @ApplicationContext
    @SupremeCommunityApplicationScope
    @Provides
    public Context getContext() {
        return context.getApplicationContext();
    }
}
