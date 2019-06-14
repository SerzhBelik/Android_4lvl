package com.example.belikov.android_4lvl.homework7.mockito1.app;

import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.presenter.RetrofitPresenter;
import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.view.RetrofitActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(RetrofitActivity retrofitActivity);

    void inject(RetrofitPresenter retrofitPresenter);
}
