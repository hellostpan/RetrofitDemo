package com.stpan.retrofitdemo.services;


import android.content.Context;

import com.stpan.retrofitdemo.activity.R;

import retrofit2.RxJavaCallAdapterFactory;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by hasee on 2016/1/26.
 */
public class RetrofitServices {
    private Context context;

    public RetrofitServices(Context context) {
        this.context = context;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(context.getResources().getString(R.string.path))
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    public RestService getRestService(){
       return retrofit.create(RestService.class);
    }
}
