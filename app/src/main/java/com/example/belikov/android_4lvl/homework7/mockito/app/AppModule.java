package com.example.belikov.android_4lvl.homework7.mockito.app;

import android.app.Application;
import android.content.Context;

import com.example.belikov.android_4lvl.homework7.mockito.model.RetrofitData;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    RetrofitData provideRetrofitData() {
        return new RetrofitData();
    }


}
