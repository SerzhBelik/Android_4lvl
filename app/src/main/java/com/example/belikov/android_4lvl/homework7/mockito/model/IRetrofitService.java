package com.example.belikov.android_4lvl.homework7.mockito.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IRetrofitService {
    @GET("/users/{login}")
    Observable<String> getUser(@Path("login") String login);

}