package com.example.belikov.android_4lvl.example.retrofit.presenter;


import com.example.belikov.android_4lvl.example.app.DaggerTestComponent;
import com.example.belikov.android_4lvl.example.app.TestComponent;
import com.example.belikov.android_4lvl.example.app.TestModule;
import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.model.RetrofitApi;
import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.model.User;
import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.presenter.RetrofitPresenter;
import com.example.belikov.android_4lvl.homework7.mockito1.retrofit.view.RetrofitView;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class RetrofitPresenterTest {

    private RetrofitPresenter presenter;

    @Mock
    RetrofitView retrofitView;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                __ -> Schedulers.trampoline());
    }

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        presenter = Mockito.spy(new RetrofitPresenter());
    }

    @Test
    public void getString_isCorrect() {
        TestComponent component = DaggerTestComponent.builder()
                .testModule(new TestModule() {

                    @Override
                    public RetrofitApi provideRetrofitApi() {
                        RetrofitApi retrofitApi = super.provideRetrofitApi();
                        User user = new User();
                        user.login = "Jack";
                        Mockito.when(retrofitApi.requestServer()).thenReturn(Observable.just(user));
                        return retrofitApi;
                    }
                }).build();

        component.inject(presenter);
        presenter.attachView(retrofitView);
        presenter.getString();
        Mockito.verify(retrofitView).showName("Jack");
    }
}
