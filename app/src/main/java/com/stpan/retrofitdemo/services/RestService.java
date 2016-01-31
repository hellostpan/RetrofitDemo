package com.stpan.retrofitdemo.services;

import java.util.HashMap;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hasee on 2016/1/26.
 */
public interface RestService {
    @GET("users/unit/{unitId}/info")
    Observable<ResultEntity<HashMap<String,Object>>> getUser(@Path("unitId") String unitId);
}
