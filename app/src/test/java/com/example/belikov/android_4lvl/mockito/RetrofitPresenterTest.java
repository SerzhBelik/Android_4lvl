package com.example.belikov.android_4lvl.mockito;

import com.example.belikov.android_4lvl.app.DaggerTestComponent;
import com.example.belikov.android_4lvl.app.TestComponent;
import com.example.belikov.android_4lvl.app.TestModule;
import com.example.belikov.android_4lvl.homework7.mockito.model.RetrofitData;
import com.example.belikov.android_4lvl.homework7.mockito.model.User;
import com.example.belikov.android_4lvl.homework7.mockito.presenter.RetrofitPresenter;
import com.example.belikov.android_4lvl.homework7.mockito.view.RetrofitView;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

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
    public void getData_isCorrect() {
        TestComponent component = DaggerTestComponent.builder()
                .testModule(new TestModule() {

                    @Override
                    public RetrofitData provideRetrofitData() {
                        RetrofitData retrofitApi = super.provideRetrofitData();
                        User user = new User();
                        user.login = "Jack";
                        Mockito.when(retrofitApi.requestServer()).thenReturn(Observable.just(user.login));
                        return retrofitApi;
                    }
                }).build();

        component.inject(presenter);
        presenter.attachView(retrofitView);
        presenter.getData();
        Mockito.verify(retrofitView).setText("Jack");
    }


}
