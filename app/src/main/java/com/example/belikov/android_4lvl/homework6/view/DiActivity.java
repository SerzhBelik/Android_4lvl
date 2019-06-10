package com.example.belikov.android_4lvl.homework6.view;

import android.os.Bundle;
import android.widget.TextView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework6.presenter.DiPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DiActivity extends MvpAppCompatActivity implements NoDiView{
    @BindView(R.id.di_text_view)
    TextView textView;

    @InjectPresenter
    public DiPresenter presenter;

    @ProvidePresenter
    public DiPresenter providePresenter(){
        return new DiPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.di_button)
    public void show(){
        presenter.show();
    }


    @Override
    public void setText(String s) {
        textView.setText(s);
    }
}
