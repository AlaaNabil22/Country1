package com.alaa.country;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alaa.country.Model.Model1;
import com.alaa.country.Model.Model2;
import com.alaa.country.Network.Api;
import com.alaa.country.Network.Retrofitclint;
import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView country_name;
    private ImageView flags;
    private Button btnc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country_name =findViewById(R.id.Cname);
        flags =findViewById(R.id.img);
        btnc =findViewById(R.id.btn);

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Loadcountry();



            }
        });


    }

    public  void  Loadcountry(){
        Api api = Retrofitclint.getclint().create(Api.class);
        Call<Model1> call=  api.getCountry();
        call.enqueue(new Callback<Model1>() {
            @Override
            public void onResponse(Call<Model1> call, Response<Model1> response) {
                if (response.isSuccessful()){

                         Model1 mod = response.body();
                         Model2 modl = mod.getResponse().get(10);
                         country_name.setText(modl.getName());
                         Glide.with(getApplicationContext())
                                 .load(modl.getFlagPng())
                                 .into(flags);

                }

                else {

                    int statusCode =response.code();
                    String massrgCode =response.message();
                    Toast.makeText(getApplicationContext(),"Code:"+String.valueOf(statusCode),Toast.LENGTH_LONG ).show();
                    Toast.makeText(getApplicationContext(),"Massege::"+massrgCode,Toast.LENGTH_LONG ).show();


                }
            }

            @Override
            public void onFailure(Call<Model1> call, Throwable t) {


                Log.i("ERROR msg :",t.getMessage());

            }
        });




    }


}
