package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfinal.DAO.BookDAO;
import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.Model.Book;
import com.example.androidfinal.Model.User;

public class EditBookActivity extends AppCompatActivity {
    private TextView txtName , txtCategory,txtQuantity,txtPrice;
    private Button btnUpdate , btnBack;
    private BookDAO bookDAO;
    private int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        txtName = findViewById(R.id.txt_upd_name);
        txtQuantity = findViewById(R.id.txt_upd_quantity);
        txtCategory = findViewById(R.id.txt_upd_category);
        txtPrice = findViewById(R.id.txt_upd_price);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        txtName.setText(b.getString("book_name"));
        txtQuantity.setText(String.valueOf(b.getInt("quantity")));
        txtCategory.setText(b.getString("category"));
        txtPrice.setText(String.valueOf(b.getDouble("price")) );
        code = b.getInt("code");
        btnBack = findViewById(R.id.btn_upd_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               back();
            }
        });
        btnUpdate = findViewById(R.id.btn_update_book);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookDAO = new BookDAO(EditBookActivity.this);
                Book book = new Book(code,txtName.getText().toString(), Integer.parseInt(txtQuantity.getText().toString()),
                        txtCategory.getText().toString(),Double.parseDouble(txtPrice.getText().toString()));

                try {
                    if (validateForm()){
                        if (bookDAO.update(book)) {
                            Toast.makeText(getApplicationContext(), "Edit book successfully", Toast.LENGTH_SHORT).show();
                            back();
                        } else {
                            Toast.makeText(getApplicationContext(), "Edit user fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception ex) {
                    Log.e("Error", ex.toString());
                }
            }
        });
    }
    public void back(){
        Intent intent = new Intent(getApplicationContext(), ListBookActivity.class);
        startActivity(intent);
    }
    public boolean validateForm(){
        if (txtName.getText().length() == 0 || txtQuantity.getText().length() == 0
                || txtCategory.getText().length() == 0 || txtPrice.getText().length()== 0){
            Toast.makeText(getApplicationContext(), "You must input all", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}