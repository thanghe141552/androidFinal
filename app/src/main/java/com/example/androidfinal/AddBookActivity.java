package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidfinal.DAO.BookDAO;
import com.example.androidfinal.DB.DatabaseHelper;
import com.example.androidfinal.Model.Book;

public class AddBookActivity extends AppCompatActivity {
    EditText txtCode,txtName,txtQuantity,txtCategory,txtPrice;
    Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        getSupportActionBar().setTitle("Add Book");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtCode = findViewById(R.id.txtCode);
        txtName = findViewById(R.id.txtName);
        txtQuantity = findViewById(R.id.txtQuantity);
        txtCategory = findViewById(R.id.txtCategory);
        txtPrice = findViewById(R.id.txtPrice);
        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDAO bookDAO = new BookDAO(AddBookActivity.this);
                Book book = new Book(Integer.parseInt(txtCode.getText().toString()) ,txtName.getText().toString(),Integer.parseInt(txtQuantity.getText().toString()),
                        txtCategory.getText().toString(),Double.parseDouble(txtPrice.getText().toString()));
                bookDAO.insertBook(book);
//                try {
//                    if (bookDAO.insertBook(book) > 0) {
//                        Toast.makeText(getApplicationContext(), "Succesfull", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Thất bại", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (Exception ex) {
//                    Log.e("Error", ex.toString());
//                }
            }
        });

    }
}