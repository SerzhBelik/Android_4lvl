package com.example.belikov.android_4lvl.example.retrofit.presenter;


import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.presenter.RetrofitPresenter;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class NoWorkRetrofitPresenterTest {

    private RetrofitPresenter retrofitPresenter;

   @Before
   public void before(){
       retrofitPresenter = new RetrofitPresenter();
   }

    @Test
    public void getString_isCorrect() throws InterruptedException {
        retrofitPresenter.getString();

        TimeUnit.SECONDS.sleep(5);
    }
}