package com.example.belikov.android_4lvl.homework6.app;

import com.example.belikov.android_4lvl.homework6.model.RedDagger;
import com.example.belikov.android_4lvl.homework6.model.WhiteDagger;
import com.example.belikov.android_4lvl.homework6.presenter.DaggerPresenter;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DaggerPresenter daggerPresenter);

    void inject(RedDagger redDagger);

    void inject(WhiteDagger whiteDagger);
}
