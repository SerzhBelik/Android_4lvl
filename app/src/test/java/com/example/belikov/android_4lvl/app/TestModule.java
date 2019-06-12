package com.example.belikov.android_4lvl.app;

import com.example.belikov.android_4lvl.homework7.mockito.model.RetrofitData;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {
    @Provides
    public RetrofitData provideRetrofitData(){
        return Mockito.mock(RetrofitData.class);
    }
}

