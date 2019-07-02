package com.example.belikov.android_4lvl.homework8.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.belikov.android_4lvl.homework8.model.RetrofitData;
import com.example.belikov.android_4lvl.homework8.model.entity.User;
import com.example.belikov.android_4lvl.homework8.view.RetrofitView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class RetrofitPresenter extends MvpPresenter<RetrofitView> {

    private static final String TAG = "RetrofitDifPresenter";

    private RetrofitData data;

    public RetrofitPresenter() {
        data = new RetrofitData();
    }

    public void getData() {
        Observable<String> single = data.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(str -> {
            Log.d(TAG, "onNext: " + str);
            Gson gson = new GsonBuilder().create();
            User user = gson.fromJson(str, User.class);
            getViewState().setImage(user.avatarUrl);
            getViewState().setText(user.login);
        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });
    }


}
