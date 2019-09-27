package com.example.supremecommunityapp.di.component;

import com.example.supremecommunityapp.di.module.PicassoModule;
import com.example.supremecommunityapp.di.module.SupremeCommunityModule;
import com.example.supremecommunityapp.di.scopes.SupremeCommunityApplicationScope;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.ui.SupremeCommunityApplication;

import dagger.Component;

@SupremeCommunityApplicationScope
@Component(modules = {SupremeCommunityModule.class, PicassoModule.class})
public interface SupremeCommunityComponent {
//
    SupremeCommunityApi getSupremeCommunityService();
    void inject(SupremeCommunityApplication supremeCommunityApplication);
//    Picasso getPicasso();
}
