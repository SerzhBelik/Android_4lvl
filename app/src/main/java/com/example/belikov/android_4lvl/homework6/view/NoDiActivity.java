package com.example.belikov.android_4lvl.homework6.view;

import android.os.Bundle;
import android.widget.TextView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework6.presenter.NoDiPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoDiActivity extends MvpAppCompatActivity implements NoDiView{

    @BindView(R.id.no_di_text_view)
    TextView textView;

    @InjectPresenter
    public NoDiPresenter presenter;

    @ProvidePresenter
    public NoDiPresenter providePresenter(){
        return new NoDiPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_di);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.no_di_button)
    public void show(){
        presenter.show();
    }


    @Override
    public void setText(String s) {
        textView.setText(s);
    }
}
