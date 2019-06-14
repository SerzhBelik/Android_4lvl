package com.example.belikov.android_4lvl.homework7.mockito.app;

import com.example.belikov.android_4lvl.homework7.mockito.presenter.RetrofitPresenter;
import com.example.belikov.android_4lvl.homework7.mockito.view.RetrofitActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(RetrofitActivity retrofitActivity);

    void inject(RetrofitPresenter retrofitPresenter);
}
