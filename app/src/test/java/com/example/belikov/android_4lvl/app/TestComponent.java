package com.example.belikov.android_4lvl.app;

import com.example.belikov.android_4lvl.homework7.mockito.presenter.RetrofitPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent {
    void inject(RetrofitPresenter presenter);

}
