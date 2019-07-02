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
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SingleActivity extends AppCompatActivity {
    private static final String TAG = "SingleActivity";
    private Disposable disposable;
    private MailPresenter mailPresenter;
    private Single<String> single;
    @BindView(R.id.text_view_single)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        mailPresenter = new MailPresenter();
        single = mailPresenter.getMailText();
        ButterKnife.bind(this);
    }

    @OnClick({R.id.subscribe_single})
    public void subscribe(View view) {
        disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(string -> {
            Log.d(TAG, "subscribe: " + string);
            textView.setText(string);
        }, throwable -> {
            Log.e(TAG, "onError: " + throwable);
        });
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
    }

    public void unsubscribe(View view) {
        disposable.dispose();
    }


}