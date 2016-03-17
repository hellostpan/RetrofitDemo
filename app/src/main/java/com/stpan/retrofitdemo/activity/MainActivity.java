package com.stpan.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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
        Observable<ResultEntity<HashMap<String,String>>> stringCall = service.getUserPost("hello stpan");
        stringCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<ResultEntity<HashMap<String, String>>>() {
            @Override
            public void call(ResultEntity<HashMap<String, String>> resultEntity) {
                Toast.makeText(MainActivity.this,resultEntity.getCode(),Toast.LENGTH_SHORT).show();
                System.out.println(resultEntity.getMessage());
                if (resultEntity.getResult()!=null){
                    HashMap<String,String> hashMap = resultEntity.getResult();
                    System.out.println(hashMap.get("id"));
                    System.out.println(hashMap.get("name"));
                    System.out.println(hashMap.get("age"));
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }


}
