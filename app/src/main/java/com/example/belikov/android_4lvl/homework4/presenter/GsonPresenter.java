package com.example.belikov.android_4lvl.homework4.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.belikov.android_4lvl.homework4.model.GsonData;
import com.example.belikov.android_4lvl.homework4.model.entity.Time;
import com.example.belikov.android_4lvl.homework4.view.GsonView;

@InjectViewState
public class GsonPresenter extends MvpPresenter<GsonView> {
    private GsonData data;
    private String TAG = "GsonPresenter";

    public GsonPresenter(){
        this.data = new GsonData();
    }

    public void onClick(){
        Time time = data.getData();
        Log.d(TAG, time.season);
        Log.d(TAG, String.valueOf(time.year));
        getViewState().setText("Complete!");
    }

}
