package com.example.belikov.android_4lvl.homework7.mockito1.retrofit.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.model.RetrofitApi;
import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.model.User;
import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.view.RetrofitView;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


@InjectViewState
public class RetrofitPresenter extends MvpPresenter<RetrofitView> {

    private static final String TAG = "RetrofitPresenter";

    @Inject
    RetrofitApi retrofitApi;

    public void getString() {
        Disposable disposable = getUserObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            Log.d(TAG, "onNext: " + user.login);
            getViewState().showName(user.login);
        }, throwable -> {
            Log.e(TAG, "onError");
        });
    }

    public Observable<User> getUserObservable() {
        return retrofitApi.requestServer();
    }

}
