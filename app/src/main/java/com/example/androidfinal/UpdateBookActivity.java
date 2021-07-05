package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UpdateBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);

        getSupportActionBar().setTitle("Update Book");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}