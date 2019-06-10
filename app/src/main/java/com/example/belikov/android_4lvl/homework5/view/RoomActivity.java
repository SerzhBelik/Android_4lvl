package com.example.belikov.android_4lvl.homework5.view;


import android.os.Bundle;
import android.widget.TextView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework5.presenter.RoomPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RoomActivity extends MvpAppCompatActivity implements RoomView {
    @BindView(R.id.room_text_view)
    TextView textView;

    @InjectPresenter
    public RoomPresenter presenter;

    @ProvidePresenter
    public RoomPresenter providePresenter(){
        return  new RoomPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);
    }


    @Override
    public void setText(String s) {
        textView.setText(s);
    }

    @OnClick(R.id.button_add_user)
    public void addUser(){
        presenter.addUser();
    }

    @OnClick(R.id.button_add_users)
    public void addUsers(){
        presenter.addUsers();
    }

    @OnClick(R.id.button_delete_user)
    public void deleteUser(){
        presenter.deleteUser();

    }

    @OnClick(R.id.button_update_user)
    public void updateUser(){
        presenter.updateUser();

    }
}
