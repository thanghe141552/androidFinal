package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class UpdateCategoryActivity extends AppCompatActivity {

    private Button backbutton;
    private Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_category);

        getSupportActionBar().setTitle("Update Category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        
    }
}