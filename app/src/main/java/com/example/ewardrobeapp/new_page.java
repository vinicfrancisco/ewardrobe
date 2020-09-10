package com.example.ewardrobeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class new_page extends AppCompatActivity {
    Button addClothesButton;
    Button addLookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new_page.this, home.class);
                startActivity(i);
            }
        });

         addClothesButton = (Button) findViewById(R.id.new_clothes_button);
         addLookButton = (Button) findViewById(R.id.new_look_button);

        addClothesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new_page.this, new_clothes.class);
                startActivity(i);
            }
        });

        addLookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new_page.this, new_look.class);
                startActivity(i);
            }
        });

    }
}