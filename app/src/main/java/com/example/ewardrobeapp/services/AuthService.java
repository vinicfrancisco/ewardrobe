package com.example.ewardrobeapp.services;

import com.example.ewardrobeapp.models.AuthResponse;
import com.example.ewardrobeapp.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("/auth?type=json")
    Call<AuthResponse> signIn(@Body User user);

    @POST("/users?type=json")
    Call<AuthResponse> signUp(@Body User user);
}
