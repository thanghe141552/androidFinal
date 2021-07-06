package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListUserActivity extends AppCompatActivity {
    private Button btnBack;
    private Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        getSupportActionBar().setTitle("List User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnAdd = (Button) findViewById(R.id.btnAdd);
    }
    public void back(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
//    public void viewAdd(View view){
//        Intent intent = new Intent(getApplicationContext(), ListUserActivity.class);
//        startActivity(intent);
//    }
}