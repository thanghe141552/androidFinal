package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidfinal.Adapter.BillAdapter;
import com.example.androidfinal.DAO.BillDAO;
import com.example.androidfinal.Model.Bill;

import java.text.ParseException;
import java.util.List;

public class ListBillActivity extends AppCompatActivity {
    private Button btnAdd , btnBack;
    private BillAdapter billAdapter;
    private ListView listViewBill;
    private BillDAO billDAO;
    private List<Bill> bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bill);

        getSupportActionBar().setTitle("List Bill");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnAdd = findViewById(R.id.btn_bill_add);
        btnBack = findViewById(R.id.btn_bill_back);
        listViewBill = findViewById(R.id.lv_bill);
        billDAO = new BillDAO(ListBillActivity.this);
        try {
            bills = billDAO.getAllBill();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        billAdapter = new BillAdapter(ListBillActivity.this,bills );
        listViewBill.setAdapter(billAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddBillActivity.class);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}