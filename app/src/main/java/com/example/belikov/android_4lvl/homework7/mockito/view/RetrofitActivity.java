package com.example.belikov.android_4lvl.homework7.mockito.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework7.mockito.app.App;
import com.example.belikov.android_4lvl.homework7.mockito.presenter.RetrofitPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RetrofitActivity extends MvpAppCompatActivity implements RetrofitView {
    @BindView(R.id.retrofit_image_view)
    ImageView imageView;

    @BindView(R.id.retrofit_text_view)
    TextView textView;

    @InjectPresenter
    RetrofitPresenter presenter;

    @ProvidePresenter
    public RetrofitPresenter providePresenter(){
        presenter = new RetrofitPresenter();
        App.getAppComponent().inject(presenter);
        return presenter;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        App.getAppComponent().inject(this);

    }

    @OnClick(R.id.retrofit_button)
    public void onClick(){
        presenter.getData();
    }




    @Override
    public void setImage(String avatarUrl) {
        Glide
                .with(this)
                .load(avatarUrl)
                .into(imageView);
        Log.d("Activity", avatarUrl);
    }

    @Override
    public void setText(String text) {
        textView.setText(text);
    }
}
