package com.example.belikov.android_4lvl.homework7.mockito1.retrofit.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;


public interface RetrofitView extends MvpView {
    @StateStrategyType(value = SkipStrategy.class)
    void showName(String name);
}
