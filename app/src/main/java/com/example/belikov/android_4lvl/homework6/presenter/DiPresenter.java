package com.example.belikov.android_4lvl.homework6.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.belikov.android_4lvl.homework6.model.Green;
import com.example.belikov.android_4lvl.homework6.model.Red;
import com.example.belikov.android_4lvl.homework6.model.White;
import com.example.belikov.android_4lvl.homework6.view.NoDiView;

@InjectViewState
public class DiPresenter extends MvpPresenter<NoDiView> {

    public DiPresenter(){
    }

    public void show() {
        Green green = new Green();
        Red red = new Red(green);
        White white = new White(green);
        getViewState().setText(green.show());
    }
}