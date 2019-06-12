package com.example.belikov.android_4lvl.homework7.mockito.presenter;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.belikov.android_4lvl.homework7.mockito.app.App;
import com.example.belikov.android_4lvl.homework7.mockito.model.RetrofitData;
import com.example.belikov.android_4lvl.homework7.mockito.model.User;
import com.example.belikov.android_4lvl.homework7.mockito.view.RetrofitView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class RetrofitPresenter extends MvpPresenter<RetrofitView> {

    private static final String TAG = "RetrofitDifPresenter";

    @Inject
    RetrofitData data;

    public RetrofitPresenter() {

    }



    public void getData() {

        Disposable disposable = getUserObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(str -> {
            Log.d(TAG, "onNext: " + str);
            Gson gson = new GsonBuilder().create();
            User user = gson.fromJson(str, User.class);
            getViewState().setImage(user.avatarUrl);
            getViewState().setText(user.login);
        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });

    }

    private Observable<String> getUserObservable(){
//        App.getAppComponent().inject(this);
        return data.requestServer();
    }


}
