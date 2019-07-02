package com.example.belikov.android_4lvl.homework8.view;


import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework8.model.RetrofitData;
import com.example.belikov.android_4lvl.homework8.presenter.RetrofitPresenter;

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
        return new RetrofitPresenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        start();
    }

    private void start() {
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void ... voids){
                while (true){
                    Log.d("Leak", "doInBackground " + RetrofitActivity.this);
                }
//                return null;
            }

        }.execute();


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
    }

    @Override
    public void setText(String text) {
        textView.setText(text);
    }
}
