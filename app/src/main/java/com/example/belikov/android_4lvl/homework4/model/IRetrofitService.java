package com.example.belikov.android_4lvl.homework4.model;

import com.example.belikov.android_4lvl.homework4.model.entity.User;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IRetrofitService {
    @GET("/users/JakeWharton")
    Observable<String> getUser();

}