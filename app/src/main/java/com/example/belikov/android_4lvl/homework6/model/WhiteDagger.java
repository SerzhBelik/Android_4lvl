package com.example.belikov.android_4lvl.homework6.model;

import android.util.Log;

import com.example.belikov.android_4lvl.homework6.app.App;

import javax.inject.Inject;

public class WhiteDagger {

    @Inject
    GreenDagger green;

    private static final String TAG = "White";

    public WhiteDagger(){
        App.getAppComponent().inject(this);
        Log.d(TAG, green.show());
        Log.d(TAG, "Green " + green);
    }
}
