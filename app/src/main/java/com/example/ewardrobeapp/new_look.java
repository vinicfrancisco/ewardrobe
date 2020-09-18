package com.example.ewardrobeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ewardrobeapp.adapters.ClothesAdapter;
import com.example.ewardrobeapp.adapters.ClothesRecycleAdapter;
import com.example.ewardrobeapp.models.Clothes;
import com.example.ewardrobeapp.models.ClothesTypes;
import com.example.ewardrobeapp.retrofit.RetrofitInitializer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class new_look extends AppCompatActivity {
    private Button saveButton;
    private RecyclerView topClothesList;
    private ClothesRecycleAdapter topClothesAdapter;
    private RecyclerView.LayoutManager topLayoutManager;

    private RecyclerView bottomClothesList;
    private ClothesRecycleAdapter bottomClothesAdapter;
    private RecyclerView.LayoutManager bottomLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_look);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        topClothesList = (RecyclerView) findViewById(R.id.top_clothes);
        bottomClothesList = (RecyclerView) findViewById(R.id.bottom_clothes);

        topClothesList.setHasFixedSize(true);
        bottomClothesList.setHasFixedSize(true);

        topLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        bottomLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);


        topClothesList.setLayoutManager(topLayoutManager);
        bottomClothesList.setLayoutManager(bottomLayoutManager);

        saveButton = (Button) findViewById(R.id.save_look_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new_look.this, home.class);
                startActivity(i);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new_look.this, home.class);
                startActivity(i);
            }
        });

        Call<ClothesTypes> call = new RetrofitInitializer().clothes().getClothesTypes();

        call.enqueue(new Callback<ClothesTypes>() {
            @Override
            public void onResponse(Call<ClothesTypes> call, Response<ClothesTypes> response) {
                ClothesTypes data = response.body();

                topClothesAdapter = new ClothesRecycleAdapter(data.getTop());
                bottomClothesAdapter = new ClothesRecycleAdapter(data.getBottom());

                topClothesList.setAdapter(topClothesAdapter);
                bottomClothesList.setAdapter(bottomClothesAdapter);

                bottomClothesList.setHasFixedSize(true);
                topClothesList.setHasFixedSize(true);

                bottomClothesList.setHorizontalScrollBarEnabled(true);
                topClothesList.setHorizontalScrollBarEnabled(true);

            }

            @Override
            public void onFailure(Call<ClothesTypes> call, Throwable t) {

            }
        });
    }
}