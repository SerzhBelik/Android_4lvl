package com.example.belikov.android_4lvl.homework6.model;

import android.util.Log;

public class White {

    private Green green;
    private static final String TAG = "White";

    public White(){
        green = new Green();
        Log.d(TAG, green.show());
        Log.d(TAG, "Green " + green);
    }
}
