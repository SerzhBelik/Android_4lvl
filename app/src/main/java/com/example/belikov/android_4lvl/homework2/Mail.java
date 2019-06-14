package com.example.belikov.android_4lvl.homework2;

import android.util.Log;

import java.util.HashSet;
import java.util.Set;

public class Mail implements Subject {
    private Set<Observer> observers = new HashSet<>();
    private int count = 0;
    private String name;
    private String num;

    public void newMail(String name, String num){
        this.name = name;
        this.num = num;
        Log.d("Mail ", "a new mail was send!");
        notifyAllObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
        Log.d("Mail", "unsubscribe");
    }

    @Override
    public void notifyAllObservers() {
        for (Observer o : observers
             ) {
            o.updateData(name, num);
        }
    }
}
