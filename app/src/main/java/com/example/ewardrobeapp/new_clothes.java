package com.example.ewardrobeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class new_clothes extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private ConstraintLayout layout;
    private ImageView clothes_image;
    private EditText nameInput;
    private EditText categoryInput;
    private Button saveButton;
    private Button openCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_clothes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new_clothes.this, new_page.class);
                startActivity(i);
            }
        });


        layout = new ConstraintLayout(this);

        nameInput = (EditText) findViewById(R.id.clothes_name);
        categoryInput = (EditText) findViewById(R.id.clothes_category);
        saveButton = (Button) findViewById(R.id.save_clothes_button);
        openCamera = (Button) findViewById(R.id.add_clothes_image);
        clothes_image = (ImageView) findViewById(R.id.new_image);

        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                String category = categoryInput.getText().toString();
            }
        });

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            clothes_image.setImageBitmap(imageBitmap);
            layout.removeView(openCamera);
        }
    }


}