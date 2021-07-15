package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgBook;
    private ImageView imgUser;
    private ImageView imgCate;
    private ImageView imgStatistic;
    private ImageView   imgBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Main Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgBook = (ImageView) findViewById(R.id.imgBook);
        imgBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListBookActivity.class);
                startActivity(intent);
            }
        });

        imgUser = (ImageView) findViewById(R.id.imgUser);
        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListUserActivity.class);
                startActivity(intent);
            }
        });
        imgBill = findViewById(R.id.imgBill);
        imgBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BillActivity.class);
                startActivity(intent);
            }
        });

        imgCate = (ImageView) findViewById(R.id.imgCategory);
        imgCate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListCategoryActivity.class);
                startActivity(intent);
            }
        });

        imgStatistic = (ImageView) findViewById(R.id.imgStatistic);
        imgStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StaticActivity.class);
                startActivity(intent);
            }
        });
    }


    }
