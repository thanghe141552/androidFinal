package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidfinal.DAO.BookDAO;

public class DetailBillActivity extends AppCompatActivity {
    private EditText txtBookID,txtQuantity;
    private Button btnAdd, btnBack;
    private BookDAO bookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bill);
        setTitle("Bill Detail");
    }
}