package com.example.belikov.android_4lvl.homework1.view;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework1.presenter.MoxyPresenter;

public class MoxyMVPActivity extends MvpAppCompatActivity implements MoxyView{

    private TextView textView;
    private EditText editText;
    private Button button;
    private static final String TAG = "MoxyMVPActivity";

    @InjectPresenter
    MoxyPresenter presenter;

    @ProvidePresenter
    public MoxyPresenter providePresenter(){
        return new MoxyPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moxy_mvp);

        initialization();
    }



    private void initialization() {

        textView = findViewById(R.id.text_view1);
        editText = findViewById(R.id.edit_text1);
        button = findViewById(R.id.button1);


    }

    public void buttonClick(View view) {
        presenter.onButtonClick(editText.getText().toString());
    }


    public void setTextView(String s){
        clearEditText();
        textView.setText(s);
    }

    private void clearEditText() {
        editText.setText("");
    }
}

