package com.example.belikov.android_4lvl.homework7.mockito1.retrofit.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String user);
}
