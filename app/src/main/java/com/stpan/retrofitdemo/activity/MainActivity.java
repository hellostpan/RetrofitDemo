package com.stpan.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stpan.retrofitdemo.services.RestService;
import com.stpan.retrofitdemo.services.ResultEntity;
import com.stpan.retrofitdemo.services.RetrofitServices;

import java.util.HashMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        RetrofitServices retrofitServices = new RetrofitServices(this);
        RestService service = retrofitServices.getRestService();
        Observable<ResultEntity<HashMap<String,Object>>> stringCall = service.getUser("4028810e4fb05fdd014fb0691f9d0007");
        stringCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<ResultEntity<HashMap<String, Object>>>() {
            @Override
            public void call(ResultEntity<HashMap<String, Object>> resultEntity) {

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }


}
