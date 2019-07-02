package com.example.belikov.android_4lvl.homework8.model;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitData {
    public Observable<String> requestServer() {

        ScalarsConverterFactory scalarsConverterFactory = ScalarsConverterFactory.create();

        IRetrofitService api = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(scalarsConverterFactory)
                .build()
                .create(IRetrofitService.class);

        return api.getUser().subscribeOn(Schedulers.io());
    }
}
