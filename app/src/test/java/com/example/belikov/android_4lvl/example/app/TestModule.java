package com.example.belikov.android_4lvl.example.app;


import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.model.RetrofitApi;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {
    @Provides
    public RetrofitApi provideRetrofitApi(){
        return Mockito.mock(RetrofitApi.class);
    }
}