package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfinal.DAO.StatisticDAO;

public class StaticActivity extends AppCompatActivity {

    private TextView tvCategory, tvUser, tvBook, tvBest, tvTotal;
    private StatisticDAO statisticDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);

        getSupportActionBar().setTitle("Statistic");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        statisticDAO = new StatisticDAO(StaticActivity.this);
        tvCategory = findViewById(R.id.tv_totalCategory);
        tvCategory.setText("Total of Category: " + String.valueOf(statisticDAO.getCategoryCount()));
        tvUser = findViewById(R.id.tv_totalUser);
        tvUser.setText("Total of User: " + String.valueOf(statisticDAO.getUserCount()));
        tvBook = findViewById(R.id.tv_totalBook);
        tvBook.setText("Total of Book: " + String.valueOf(statisticDAO.getBookCount()));
        tvBest = findViewById(R.id.tv_bestseller);
        tvBest.setText("Best seller: " + statisticDAO.getBestSellerBook());
        tvTotal = findViewById(R.id.tv_totalmoney);
        tvTotal.setText("Total money earn: " + String.valueOf(statisticDAO.getTotalMoney()));

    }
}