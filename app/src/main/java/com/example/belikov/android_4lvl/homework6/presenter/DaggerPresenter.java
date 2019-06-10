package com.example.belikov.android_4lvl.homework6.presenter;


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.belikov.android_4lvl.homework6.app.App;
import com.example.belikov.android_4lvl.homework6.model.GreenDagger;
import com.example.belikov.android_4lvl.homework6.model.RedDagger;
import com.example.belikov.android_4lvl.homework6.model.WhiteDagger;
import com.example.belikov.android_4lvl.homework6.view.NoDiView;

import javax.inject.Inject;

@InjectViewState
public class DaggerPresenter extends MvpPresenter<NoDiView> {

    private static final String TAG = "DaggerPresenter";

    @Inject
    GreenDagger green;
    @Inject
    RedDagger red;
    @Inject
    WhiteDagger white;

    public DaggerPresenter(){

    }

    public void show() {
        Log.d(TAG, this.toString());
        App.getAppComponent().inject(this);
        getViewState().setText(green.show());

    }
}
