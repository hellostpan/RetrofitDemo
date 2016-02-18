package com.stpan.retrofitdemo.services;


import android.content.Context;

import com.stpan.retrofitdemo.activity.R;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hasee on 2016/1/26.
 */
public class RetrofitServices {
    private Context context;

    public RetrofitServices(Context context) {
        this.context = context.getApplicationContext();
    }

    private Retrofit getRetrofit(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();
         return new Retrofit.Builder()
                .baseUrl(context.getResources().getString(R.string.path))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    public RestService getRestService(){
       return getRetrofit().create(RestService.class);
    }
}
