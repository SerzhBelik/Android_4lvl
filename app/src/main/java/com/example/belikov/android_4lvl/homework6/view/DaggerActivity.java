package com.example.belikov.android_4lvl.homework6.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework6.presenter.DaggerPresenter;
import com.example.belikov.android_4lvl.homework6.presenter.DiPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DaggerActivity extends MvpAppCompatActivity implements NoDiView{

    @BindView(R.id.dagger_text_view)
    TextView textView;

    @InjectPresenter
    public DaggerPresenter presenter;

    @ProvidePresenter
    public DaggerPresenter providePresenter(){
        return new DaggerPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ButterKnife.bind(this);
//        presenter.attachView(this);
    }
    @OnClick(R.id.dagger_button)
    public void show(){
        presenter.show();
    }


    @Override
    public void setText(String s) {
        textView.setText(s);
    }
}
