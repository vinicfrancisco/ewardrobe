package com.example.ewardrobeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ewardrobeapp.models.AuthResponse;
import com.example.ewardrobeapp.models.User;
import com.example.ewardrobeapp.retrofit.RetrofitInitializer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {
    private EditText nameInput;
    private EditText nicknameInput;
    private EditText genreInput;
    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(register.this, login.class);
                startActivity(i);
            }
        });

        registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameInput = (EditText) findViewById(R.id.nameInput);
                nicknameInput = (EditText) findViewById(R.id.nicknameInput);
                genreInput = (EditText) findViewById(R.id.genreInput);
                emailInput = (EditText) findViewById(R.id.emailInput);
                passwordInput = (EditText) findViewById(R.id.passwordInput);

                String name = nameInput.getText().toString();
                String nickname = nicknameInput.getText().toString();
                String genre = genreInput.getText().toString();
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                User user = new User(name, nickname, genre, email, password);

                Call<AuthResponse> call = new RetrofitInitializer().auth().signUp(user);
                call.enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        Intent i = new Intent(register.this, home.class);
                        startActivity(i);                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        // Display error message;
                    }
                });

                Intent i = new Intent(register.this, home.class);
                startActivity(i);
            }
        });
    }
}