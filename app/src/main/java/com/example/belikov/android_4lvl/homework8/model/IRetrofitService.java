package com.example.belikov.android_4lvl.homework8.model;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IRetrofitService {
    @GET("/users/JakeWharton")
    Observable<String> getUser();

}