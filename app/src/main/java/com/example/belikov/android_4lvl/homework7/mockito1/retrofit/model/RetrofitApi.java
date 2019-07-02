package com.example.belikov.android_4lvl.homework7.mockito1.retrofit.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    public Observable<User> requestServer() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        RxJava2CallAdapterFactory factory = RxJava2CallAdapterFactory.create();

        RetrofitService api = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addCallAdapterFactory(factory)
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(RetrofitService.class);

        return api.getUser("JakeWharton").subscribeOn(Schedulers.io());
    }
}
