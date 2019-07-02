package com.example.belikov.android_4lvl.homework5.presenter;


import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.belikov.android_4lvl.homework5.App;
import com.example.belikov.android_4lvl.homework5.model.User;
import com.example.belikov.android_4lvl.homework5.model.UserDao;
import com.example.belikov.android_4lvl.homework5.view.RoomView;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class RoomPresenter extends MvpPresenter<RoomView> {

    private static final String TAG = "RoomPresenter";
    private UserDao userDao = App.getAppDatabase().userDao();
    private User user;

    public RoomPresenter() {

    }


    public void addUser() {
        Disposable disposable = putUser().observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "put data " + id);
                    getViewState().setText("User add with id = " + id);
                }, throwable -> {
                    Log.d(TAG, "put data " + throwable);
                });

    }

    public void addUsers() {

        Disposable disposable = putUsers().observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    Log.d(TAG, "put data " + users);
                    getViewState().setText("Users add! " + users);
                    getAll();
                }, throwable -> {
                    Log.d(TAG, "put data " + throwable);
                });

    }

    private void getAll() {
       Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
               .subscribe(users -> {
                   for (User user : users
                           ) {
                       Log.d(TAG, user.toString());
                   }
               });
    }


    private Single<List<User>> putUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", "Ivanov", 30));
        users.add(new User("Petr", "Petrov", 29));

        return Single.create((SingleOnSubscribe<List<User>>) emitter -> {
            Log.d(TAG, "adding");
            userDao.insertList(users);
            Log.d(TAG, "adding users " + users);
            emitter.onSuccess(users);
        }).subscribeOn(Schedulers.io());


    }

    public void deleteUser() {
        Disposable disposable = removeUser().observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    Log.d(TAG, "delete data " + user);
                    getViewState().setText("User delete with id = " + user);
                }, throwable -> {
                    Log.d(TAG, "delete data " + throwable);
                });
    }

    private Single<Integer> removeUser() {
        user = new User("John", "Snow", 34);
        user.id = 2;

        return Single.create((SingleOnSubscribe<Integer>) emitter -> {
            int i = userDao.delete(user);
            Log.d(TAG, "delete user " + user);
            emitter.onSuccess(i);
        }).subscribeOn(Schedulers.io());
    }

    public void updateUser() {
        Disposable disposable = changeUser().observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    Log.d(TAG, "change data " + user);
                    getViewState().setText("User update with id = " + user);
                }, throwable -> {
                    Log.d(TAG, "delete data " + throwable);
                });
    }

    private Single<Integer> changeUser() {
        user = new User("John", "Snow", 25);

        return Single.create((SingleOnSubscribe<Integer>) emitter -> {
            int i = userDao.delete(user);
            Log.d(TAG, "update user " + user);
            emitter.onSuccess(i);
        }).subscribeOn(Schedulers.io());
    }

    private Single<Long> putUser() {

        user = new User("Petr", "Petrov", 29);
        return Single.create((SingleOnSubscribe<Long>) emitter -> {
            Log.d(TAG, "adding");
            long id = userDao.insert(user);
            Log.d(TAG, "adding id = " + id);
            emitter.onSuccess(id);
        }).subscribeOn(Schedulers.io());

    }
}
