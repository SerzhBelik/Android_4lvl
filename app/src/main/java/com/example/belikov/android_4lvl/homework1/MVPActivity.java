package com.example.belikov.android_4lvl.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.belikov.android_4lvl.R;
import com.example.belikov.android_4lvl.homework1.presenter.MainPresenter;
import com.example.belikov.android_4lvl.homework1.view.MainView;

public class MVPActivity extends AppCompatActivity implements MainView {
    private TextView textView;
    private EditText editText;
    private Button button;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        initialization();
    }

    private void initialization() {

        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);

        mainPresenter = new MainPresenter(this);

    }

    public void buttonClick(View view) {
        mainPresenter.onButtonClick(editText.getText().toString());
    }

    public void setTextView(String s){
        clearEditText();
        textView.setText(s);
    }

    private void clearEditText() {
        editText.setText("");
    }
}
