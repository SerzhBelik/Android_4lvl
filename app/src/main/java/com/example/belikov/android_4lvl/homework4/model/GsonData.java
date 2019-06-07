package com.example.belikov.android_4lvl.homework4.model;

import com.example.belikov.android_4lvl.homework4.model.entity.Time;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonData {
    private Gson gson;
    public String getJson() {
        return json;
    }

    private String json = "{\"time_of_year\": \"summer\", \"year\": 2019} ";

    public Time getData(){
        gson = new GsonBuilder().create();
        return gson.fromJson(json, Time.class);
    }
}
