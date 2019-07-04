package com.alaa.country.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclint {


    private  static Retrofit retrofit =null ;

    public static Retrofit getclint() {
        if (retrofit==null) {
             retrofit = new Retrofit.Builder()
                    .baseUrl("https://countryapi.gear.host/v1/Country/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;

    }

}
