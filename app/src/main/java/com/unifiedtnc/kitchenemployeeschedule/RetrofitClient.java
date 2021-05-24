package com.unifiedtnc.kitchenemployeeschedule;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private  static String BASE_URL="https://unifiedtnc.com/kichtencleaning/api/";
    private  static RetrofitClient retrofitClient;
    private  static Retrofit retrofit;


    private RetrofitClient(){

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public   static synchronized RetrofitClient getInstance(){
        if (retrofitClient==null)
        {
            retrofitClient=new RetrofitClient();
        }
        return retrofitClient;
    }


    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
