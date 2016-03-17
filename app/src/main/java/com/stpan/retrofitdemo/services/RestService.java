package com.stpan.retrofitdemo.services;

import java.util.HashMap;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hasee on 2016/1/26.
 */
public interface RestService {
    @GET("user")
    Observable<ResultEntity<HashMap<String,String>>> getUser();

    @FormUrlEncoded
    @POST("user")
    Observable<ResultEntity<HashMap<String,String>>> getUserPost(@Field(value = "name")String name);
}
