package com.stpan.retrofitdemo.services;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 功能：
 * 创建时间:2016/1/27 10:01
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class LoggingInterceptor implements Interceptor {
    @Override public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        /*long t1 = System.nanoTime();
        logger.info(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));*/

        Response response = chain.proceed(request);

        /*long t2 = System.nanoTime();
        logger.info(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));*/

        return response;
    }
}
