package com.example.belikov.android_4lvl.homework1.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface MoxyView extends MvpView {

    @StateStrategyType(value = SkipStrategy.class)
    void setTextView(String s);

}
