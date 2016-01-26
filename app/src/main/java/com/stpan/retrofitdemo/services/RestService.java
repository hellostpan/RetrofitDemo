package com.stpan.retrofitdemo.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hasee on 2016/1/26.
 */
public interface RestService {
    @GET("users/{id}")
    Call<String> getUser(@Path("id") String id);
}
