package com.example.belikov.android_4lvl.homework8.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("login")
    public String login;

    @Expose
    @SerializedName("company")
    public String company;

    @Expose
    @SerializedName("avatar_url")
    public String avatarUrl;
}
