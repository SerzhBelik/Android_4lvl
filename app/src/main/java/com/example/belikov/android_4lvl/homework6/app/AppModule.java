package com.example.belikov.android_4lvl.homework6.app;

import android.app.Application;

import com.example.belikov.android_4lvl.homework6.model.GreenDagger;
import com.example.belikov.android_4lvl.homework6.model.RedDagger;
import com.example.belikov.android_4lvl.homework6.model.WhiteDagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    GreenDagger provideGreenDagger() {
        return new GreenDagger();
    }

    @Singleton
    @Provides
    RedDagger provideRedDagger() {
        return new RedDagger();
    }

    @Singleton
    @Provides
    WhiteDagger provideWhiteDagger() {
        return new WhiteDagger();
    }

}