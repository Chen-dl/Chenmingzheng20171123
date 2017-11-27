package com.bawei.fanxinhua.utils;

import com.bawei.fanxinhua.netinterfece.RetrofitInterface;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by dell on 2017/11/23.
 */

public class RetrofitUtils {
    public static RetrofitInterface doHttpDeal(String url) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                //  .addInterceptor(new LogInterceptor())
//              .addNetworkInterceptor(new MyInterceptro())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .baseUrl(url)
                .build();
        RetrofitInterface api = retrofit.create(RetrofitInterface.class);
        return api;

    }
}
