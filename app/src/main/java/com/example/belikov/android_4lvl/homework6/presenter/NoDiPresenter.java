package com.example.belikov.android_4lvl.homework6.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.belikov.android_4lvl.homework6.model.Green;
import com.example.belikov.android_4lvl.homework6.model.Red;
import com.example.belikov.android_4lvl.homework6.model.White;
import com.example.belikov.android_4lvl.homework6.view.NoDiView;

@InjectViewState
public class NoDiPresenter extends MvpPresenter<NoDiView> {

    public NoDiPresenter(){
    }

    public void show() {
        Green green = new Green();
        Red red = new Red();
        White white = new White();
        getViewState().setText(green.show());
    }
}
