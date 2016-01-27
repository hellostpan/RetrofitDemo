package com.stpan.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stpan.retrofitdemo.services.LoggingInterceptor;
import com.stpan.retrofitdemo.services.RestService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.path))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        RestService service = retrofit.create(RestService.class);
        Call<String> stringCall = service.getUser("123");
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response) {
                String s = response.body();
                System.out.println("result: "+s);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

    }


}
