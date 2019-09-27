package com.example.supremecommunityapp.di.module;

import com.example.supremecommunityapp.di.scopes.SupremeCommunityApplicationScope;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpClientModule.class)
public class SupremeCommunityModule {

    @Provides
    @SupremeCommunityApplicationScope
    public SupremeCommunityApi supremeCommunityApi(Retrofit retrofit){
        return retrofit.create(SupremeCommunityApi.class);
    }

    @Provides
    @SupremeCommunityApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient,
                             GsonConverterFactory gsonConverterFactory, Gson gson){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://www.supremenewyork.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    @Provides
    @SupremeCommunityApplicationScope
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @SupremeCommunityApplicationScope
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }
}
