package com.example.belikov.android_4lvl.homework1.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.belikov.android_4lvl.homework1.model.Model;

import com.example.belikov.android_4lvl.homework1.view.MoxyView;

@InjectViewState
public class MoxyPresenter extends MvpPresenter<MoxyView> {

    private Model model;

    public MoxyPresenter (){
        model = new Model();
    }

    private void concatenate(String s){
        model.setS(model.getS() + s);
    }

    public void onButtonClick(String s){
        concatenate(s);
        getViewState().setTextView(model.getS());
    }
}
