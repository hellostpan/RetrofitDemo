package com.stpan.retrofitdemo.services;

import java.util.Map;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hasee on 2016/1/26.
 */
public interface RestService {
    @GET("users/unit/{unitId}")
    Observable getUser(@Path("unitId") String unitId);
}
