package com.example.ewardrobeapp.services;

import com.example.ewardrobeapp.models.Look;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LooksService {
    @GET("/looks")
    Call<List<Look>> getLooks();
}
