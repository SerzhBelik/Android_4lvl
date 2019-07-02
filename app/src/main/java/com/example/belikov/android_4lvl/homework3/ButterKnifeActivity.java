package com.example.belikov.android_4lvl.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework2.MailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ButterKnifeActivity extends AppCompatActivity {

    private static final String TAG = "ButterKnifeActivity";
    private Disposable disposable;
    private MailPresenter mailPresenter;
    private Observable<String> observable;
    @BindView(R.id.text_view_butter)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        mailPresenter = new MailPresenter();
        observable = mailPresenter.getMail();
        ButterKnife.bind(this);
    }

    @OnClick({R.id.subscribe_butter_knife})
    public void subscribe(View view) {
        disposable = observable.observeOn(AndroidSchedulers.mainThread()).subscribe(string -> {
                    Log.d(TAG, "onNext: " + string);
                }, throwable -> {
                    Log.e(TAG, "onError: " + throwable);
                }, () -> {
                    Log.d(TAG, "onComplete: ");
                    textView.setText("Complete!");
        });
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
    }

    @OnClick({R.id.unsubscribe_butter_knife})
    public void unsubscribe(View view) {
        disposable.dispose();
    }


}
