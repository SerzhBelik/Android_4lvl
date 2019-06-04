package com.example.belikov.android_4lvl.homework2;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MailObserver implements Observer<String> {

    private static final String TAG = "Mail Observer";

    @Override
    public void onSubscribe(Disposable disposable) {
        Log.d(TAG, "onSubscribe: ");
        RxActivity.setDisposable(disposable);
    }

    @Override
    public void onNext(String s) {
        Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: " + e);
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }
}
