package com.example.belikov.android_4lvl.homework6.model;

import android.util.Log;

import com.example.belikov.android_4lvl.homework6.app.App;

import javax.inject.Inject;

public class RedDagger {

    private static final String TAG = "Red";

    @Inject
    GreenDagger green;

    public RedDagger(){
        App.getAppComponent().inject(this);
        Log.d(TAG, green.show());
        Log.d(TAG, "Green " + green);

    }

}
