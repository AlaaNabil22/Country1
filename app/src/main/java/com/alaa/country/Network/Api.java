package com.alaa.country.Network;

import com.alaa.country.Model.Model1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("getCountries?pNativeLanguage=eng")
    Call<Model1> getCountry();

}
