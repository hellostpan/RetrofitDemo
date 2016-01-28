package com.stpan.retrofitdemo.services;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hasee on 2016/1/26.
 */
public interface RestService {
    @GET("hello/hello2/{name}")
    Observable<HashMap<String,String>> getUser(@Path("name") String name);
}
