package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidfinal.DAO.CategoryDAO;

public class DetailCategoryActivity extends AppCompatActivity {

    private TextView dtName, dtLocation, dtDescription;
    private CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_category);

        getSupportActionBar().setTitle("Category Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dtName = findViewById(R.id.dt_name);
        dtLocation = findViewById(R.id.dt_location);
        dtDescription = findViewById(R.id.dt_description);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        dtName.setText(b.getString("catName"));
        dtLocation.setText(b.getString("catLoc"));
        dtDescription.setText(b.getString("catDes"));

    }
}