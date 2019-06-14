package com.example.belikov.android_4lvl.homework5;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.belikov.android_4lvl.homework5.model.AppDatabase;

public class App extends Application {

    private static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "room_database").build();
    }

    public static AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
