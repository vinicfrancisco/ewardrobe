package com.example.ewardrobeapp.services;

import com.example.ewardrobeapp.models.Clothes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClothesService {
    @GET("/clothes")
    Call<List<Clothes>> getClothes();
}
