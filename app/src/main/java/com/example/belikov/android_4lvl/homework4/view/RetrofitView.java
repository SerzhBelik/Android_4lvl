package com.example.belikov.android_4lvl.homework4.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface RetrofitView extends MvpView {

    @StateStrategyType(value = SkipStrategy.class)
    void setImage(String avatarUrl);
    void setText(String text);

}
