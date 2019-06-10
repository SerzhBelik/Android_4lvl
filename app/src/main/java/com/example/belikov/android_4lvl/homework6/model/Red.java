package com.example.belikov.android_4lvl.homework6.model;

import android.util.Log;

public class Red {

    private Green green;
    private static final String TAG = "Red";

    public Red(){
        green = new Green();
        Log.d(TAG, green.show());
        Log.d(TAG, "Green " + green);
    }

    public Red(Green green){
        this.green = green;
        Log.d(TAG, green.show());
        Log.d(TAG, "Green " + green);
    }

    }
