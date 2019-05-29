package com.example.belikov.android_4lvl.homework2;

import android.util.Log;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class MailPresenter {

    private static final String TAG = "MailPresenter";


    public Observable<String> getMail() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 0; i < 10; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String mail = "mail: " + i;
                        Log.d(TAG, "getMail: " + Thread.currentThread().getName() + ": " + mail);
                        emitter.onNext(mail);
                    }

                    emitter.onComplete();

                } catch (InterruptedException e) {
                    Log.d(TAG, "getMail: not disposed");
                }
            }
        }).subscribeOn(Schedulers.io());

        return observable;
    }

    public Single<String> getMailText(){

    Single<String> single = Single.create((SingleOnSubscribe<String>) emiter ->{
        String mailText = "Hello!";
        Log.d(TAG, "getMailText: " + Thread.currentThread().getName() + ": " + mailText);
        emiter.onSuccess(mailText);
    }).subscribeOn(Schedulers.io());
    return single;
    }

}
