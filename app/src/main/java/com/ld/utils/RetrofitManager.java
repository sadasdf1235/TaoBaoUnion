package com.ld.utils;

import android.graphics.BitmapFactory;

import com.ld.model.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager{
    private final API api;
    private Retrofit retrofit;
    private static RetrofitManager retrofitManager = new RetrofitManager();
    public static RetrofitManager getInstance(){
        return retrofitManager;
    }
    private RetrofitManager(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
    }
    public Retrofit getRetrofit(){
        return  retrofit;
    }
    public API getApi(){
        return api;
    }
}
