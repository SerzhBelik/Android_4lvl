package com.example.belikov.android_4lvl.homework7.mockito1.retrofit.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework7.mockito1.app.App;
import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.presenter.RetrofitPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RetrofitActivity extends MvpAppCompatActivity implements RetrofitView{

    private static final String TAG = "RetrofitActivity";

    @BindView(R.id.text_view_name_activity_retrofit)
    TextView textViewName;

    @InjectPresenter
    RetrofitPresenter retrofitPresenter;

    @ProvidePresenter
    public RetrofitPresenter providePresenter(){
        retrofitPresenter = new RetrofitPresenter();
        App.getAppComponent().inject(retrofitPresenter);
        return retrofitPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit1);
        ButterKnife.bind(this);
        App.getAppComponent().inject(this);
    }

    @OnClick(R.id.button_activity_retrofit)
    public void onClickButton(View view) {
        Log.d(TAG, "onClickButton: ");
        retrofitPresenter.getString();
    }

    @Override
    public void showName(String name) {
        textViewName.setText(name);
    }
}
