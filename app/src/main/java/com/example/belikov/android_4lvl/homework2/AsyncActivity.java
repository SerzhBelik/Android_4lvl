package com.example.belikov.android_4lvl.homework2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.belikov.android_4lvl.R;

import java.util.concurrent.TimeUnit;

public class AsyncActivity extends AppCompatActivity {
    private MyAsyncTask task;
    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
    }

    public void buttonClick(View view){
        task = new MyAsyncTask();
        task.execute();
        Log.d(TAG, "buttonClick done!");
    }


    private class MyAsyncTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            for (int i = 0; i < 5; i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    Log.d(Thread.currentThread().toString(), ": iteration " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Done!";
        }
    }
}
