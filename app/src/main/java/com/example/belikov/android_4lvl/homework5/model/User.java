package com.example.belikov.android_4lvl.homework5.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "room_database")
public class User {

    public User(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "surname")
    public String surname;

    @ColumnInfo(name = "age")
    public int age;

    @Override
    public String toString() {
        return "User [" + "id = " + id +
                ", name = " + name +
                ", surname = " + surname +
                ", age = " + age +
                "]";
    }
}
