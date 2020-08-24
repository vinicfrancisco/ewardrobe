package com.example.ewardrobeapp.retrofit;

import com.example.ewardrobeapp.services.AuthService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitInitializer {
    private final Retrofit retrofit;

    public RetrofitInitializer() {
        retrofit = new Retrofit.Builder().baseUrl("https://ewardrobe-api.herokuapp.com")
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public AuthService auth() {
        return retrofit.create(AuthService.class);
    }
}
