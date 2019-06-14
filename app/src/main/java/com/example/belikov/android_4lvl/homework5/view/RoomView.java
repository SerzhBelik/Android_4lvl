package com.example.belikov.android_4lvl.homework5.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface RoomView extends MvpView {
    @StateStrategyType(value = SkipStrategy.class)
    void setText(String s);
}
