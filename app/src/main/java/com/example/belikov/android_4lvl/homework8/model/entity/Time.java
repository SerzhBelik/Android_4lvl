package com.example.belikov.android_4lvl.homework8.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time {
    @Expose
    @SerializedName("time_of_year")
    public String season;

    @Expose
    @SerializedName("year")
    public int year;
}
