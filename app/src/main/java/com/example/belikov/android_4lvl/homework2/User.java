package com.example.belikov.android_4lvl.homework2;

import android.util.Log;

public class User implements Observer {
    String name;

    public User(String name){
        this.name = name;
    }
    @Override
    public void updateData(String name, String num) {
        Log.d(this.name, " get mail: " + name + " " + num + " in the thread " + Thread.currentThread());
    }
}
