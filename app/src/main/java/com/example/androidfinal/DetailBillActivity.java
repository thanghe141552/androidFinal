package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidfinal.DAO.BillDAO;
import com.example.androidfinal.Model.Bill;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailBillActivity extends AppCompatActivity {
    private EditText txtBillId,txtUsername,txtQuantity,txtBookName,txtTotalPrice,txtPaid,txtDate;
    private BillDAO billDAO;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Date date;
    String format;
    public List<Bill> listBill = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bill);
        setTitle("Bill Detail");

        txtBillId = findViewById(R.id.txt_bill_detail_code);
        txtUsername = findViewById(R.id.txt_bill_detail_username);
        txtQuantity = findViewById(R.id.txt_bill_detail_quantity);
        txtBookName = findViewById(R.id.txt_bill_detail_book_name);
        txtTotalPrice = findViewById(R.id.txt_bill_detail_total_price);
        txtDate = findViewById(R.id.txt_bill_detail_date);
        txtPaid = findViewById(R.id.txt_bill_detail_paid);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();


        txtBillId.setText(String.valueOf("Bill id: "+ b.getInt("bill_id")));
        txtUsername.setText("Username: "+b.getString("user_name"));
        txtQuantity.setText("Quantity: "+String.valueOf(b.getInt("quantity")));
        txtBookName.setText("Book name: "+String.valueOf(b.getInt("book_name")));
        txtDate.setText("Date : "+sdf.format(new Date( b.getString("date"))));
        txtTotalPrice.setText("Total price: "+String.valueOf(b.getDouble("total_price")));
        boolean paided = b.getBoolean("paid");
        if(paided){
            txtPaid.setText("Paid : Complete!");
        }else{
            txtPaid.setText("Paid : Not yet!");
        }
    }
}