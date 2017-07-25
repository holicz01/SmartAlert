package com.anonymus.smartalert.network;

import android.content.Context;

import com.anonymus.smartalert.Contextor;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by peem-jirayu on 11/11/2559.
 */

public class HttpManager {
    private static HttpManager instance;
    public static Retrofit retrofit;
    public static HttpManager getInstance() {
        if (instance == null)
            instance = new HttpManager();
            return instance;

    }
    private Context mContext;
    private ApiService service;
    private HttpManager(){
        mContext = Contextor.getInstance().getContext();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://globalsmartalert.com/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    service = retrofit.create(ApiService.class);

    }

    public ApiService getService(){
        return service;
    }
}
