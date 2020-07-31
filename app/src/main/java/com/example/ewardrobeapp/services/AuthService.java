package com.example.ewardrobeapp.services;

import com.example.ewardrobeapp.models.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface AuthService {
    @POST("/auth")
    Call<AuthResponse> signIn(@Field("email") String email,
                              @Field("password") String password);

    @POST("/users")
    Call<AuthResponse> signUp(@Field("name") String name,
                              @Field("nickname") String nickname,
                              @Field("genre") String genre,
                              @Field("email") String email,
                              @Field("password") String password);
}
