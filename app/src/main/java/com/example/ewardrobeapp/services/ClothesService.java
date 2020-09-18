package com.example.ewardrobeapp.services;

import com.example.ewardrobeapp.models.Clothes;
import com.example.ewardrobeapp.models.ClothesTypes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClothesService {
    @GET("/clothes")
    Call<List<Clothes>> getClothes();

    @GET("/clothes/types")
    Call<ClothesTypes> getClothesTypes();
}
