package com.example.belikov.android_4lvl.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.belikov.android_4lvl.R;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RxActivity extends AppCompatActivity {

    private static final String TAG = "RxActivity";
    private static Disposable disposable;
    private MailPresenter mailPresenter;
    private Observable<String> observable;
    private MailObserver mailObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        mailPresenter = new MailPresenter();
        observable = mailPresenter.getMail();

    }

    public void subscribe(View view) {
        mailObserver = new MailObserver();
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(mailObserver);
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
    }

    public void unsubscribe(View view) {
        disposable.dispose();
    }


    public static void setDisposable(Disposable disposable) {
        RxActivity.disposable = disposable;
    }

}
