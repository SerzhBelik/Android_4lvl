package com.example.belikov.android_4lvl.example.app;

import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.presenter.RetrofitPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent {
    void inject(RetrofitPresenter presenter);

}
