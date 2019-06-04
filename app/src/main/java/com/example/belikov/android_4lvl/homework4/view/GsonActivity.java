package com.example.belikov.android_4lvl.homework4.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework4.presenter.GsonPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GsonActivity extends MvpAppCompatActivity implements GsonView {
    @BindView(R.id.gson_text_view)
    TextView textView;

    @InjectPresenter
    public GsonPresenter presenter;

    @ProvidePresenter
    public GsonPresenter providePresenter(){
        return new GsonPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.gson_button)
    public void onClick(){
        presenter.onClick();
    }

    @Override
    public void setText(String s) {
        Log.d("Main", "Complete");
        textView.setText(s);
    }
}
