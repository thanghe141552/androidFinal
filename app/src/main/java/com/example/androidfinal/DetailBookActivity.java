package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidfinal.DAO.BookDAO;

public class DetailBookActivity extends AppCompatActivity {
    private TextView txtName , txtCategory,txtQuantity,txtPrice;
    private Button btnBack;
    private BookDAO bookDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        getSupportActionBar().setTitle("Detail Book");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtName = findViewById(R.id.txt_detail_name);
        txtQuantity = findViewById(R.id.txt_detail_quantity);
        txtCategory = findViewById(R.id.txt_detail_category);
        txtPrice = findViewById(R.id.txt_detail_price);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        txtName.setText(b.getString("book_name"));
        txtQuantity.setText(String.valueOf(b.getInt("quantity")));
        txtCategory.setText(b.getString("category"));
        txtPrice.setText(String.valueOf(b.getDouble("price")) );
        
    }
}