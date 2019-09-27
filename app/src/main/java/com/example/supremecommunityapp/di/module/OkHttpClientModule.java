package com.example.supremecommunityapp.di.module;

import android.content.Context;

import com.example.supremecommunityapp.di.module.ContextModule;
import com.example.supremecommunityapp.di.qualifiers.ApplicationContext;
import com.example.supremecommunityapp.di.scopes.SupremeCommunityApplicationScope;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class OkHttpClientModule {

    @Provides
    @SupremeCommunityApplicationScope
    public OkHttpClient getOkHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor){
        return  new OkHttpClient().newBuilder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @SupremeCommunityApplicationScope
    public Cache getCache(File cacheFile){
        return new Cache(cacheFile, 10 * 1000 * 1000); //10MB
    }

    @Provides
    @SupremeCommunityApplicationScope
    public File getFile(@ApplicationContext Context context){
        File file = new File(context.getCacheDir(), "HttpCache");
        file.mkdirs();
        return file;
    }

    @Provides
    @SupremeCommunityApplicationScope
    public HttpLoggingInterceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

}
