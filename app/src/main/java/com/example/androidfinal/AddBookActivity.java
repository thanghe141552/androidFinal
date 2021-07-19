package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidfinal.Adapter.CategoryDropdownAdapter;
import com.example.androidfinal.DAO.BookDAO;
import com.example.androidfinal.DAO.CategoryDAO;
import com.example.androidfinal.Model.Book;
import com.example.androidfinal.Model.Category;

import java.util.List;

public class AddBookActivity extends AppCompatActivity {
    EditText txtCode, txtName, txtQuantity, txtPrice;
    Spinner spinnerCategory;
    Button btn_add, btn_back;
    CategoryDropdownAdapter cateAdapter;
    CategoryDAO categoryDAO;
    List<Category> categoryList;
    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        getSupportActionBar().setTitle("Add Book");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txtName = findViewById(R.id.txtName);
        txtQuantity = findViewById(R.id.txtQuantity);
        txtPrice = findViewById(R.id.txtPrice);
        btn_add = findViewById(R.id.btn_add);
        btn_back = findViewById(R.id.btnBackAddBook);

        categoryDAO = new CategoryDAO(AddBookActivity.this);
        categoryList = categoryDAO.showCategory();
        spinnerCategory = findViewById(R.id.spin_category);
        cateAdapter = new CategoryDropdownAdapter(AddBookActivity.this, categoryList);
        spinnerCategory.setAdapter(cateAdapter);
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = categoryList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(AddBookActivity.this, "Must choose category", Toast.LENGTH_SHORT).show();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDAO bookDAO = new BookDAO(AddBookActivity.this);
                if (validateForm()) {
                    Book book = new Book(txtName.getText().toString(), Integer.parseInt(txtQuantity.getText().toString()),
                            category.getCateName(), Double.parseDouble(txtPrice.getText().toString()));
                    bookDAO.insertBook(book);
                }
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListBookActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean validateForm() {
        if (txtName.getText().length() == 0 || txtQuantity.getText().length() == 0 || txtPrice.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "You must insert all", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}