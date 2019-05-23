package com.example.belikov.android_4lvl.homework1.presenter;

import com.example.belikov.android_4lvl.homework1.model.Model;
import com.example.belikov.android_4lvl.homework1.view.MainView;

public class MainPresenter {

    private MainView mainView;
    private Model model;

    public MainPresenter (MainView mainView){
        this.mainView = mainView;
        model = new Model();
    }

    private void concatenate(String s){
        model.setS(model.getS() + s);
    }

    public void onButtonClick(String s){
        concatenate(s);
        mainView.setTextView(model.getS());
    }
}
