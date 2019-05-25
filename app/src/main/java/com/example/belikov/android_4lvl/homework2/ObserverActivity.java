package com.example.belikov.android_4lvl.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.belikov.android_4lvl.R;

public class ObserverActivity extends AppCompatActivity {
    private int mailCount = 1;
    private Mail mail = new Mail();
    private User user = new User("Jack");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
    }

    public void subscribe(View view){
             mail.registerObserver(user);
    }

    public void unsubscribe(View view){
        mail.unregisterObserver(user);
    }

    public void emitter(View view){
        mail.newMail("spam", " " + mailCount++);
    }


}
