package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidfinal.DAO.CategoryDAO;
import com.example.androidfinal.Model.Category;

public class AddCategoryActivity extends AppCompatActivity {

    private Button buttonadd;
    private Button buttonback;
    private EditText etName, etLoc, etDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        getSupportActionBar().setTitle("Add Category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = (EditText) findViewById(R.id.et_name);
        etLoc = (EditText) findViewById(R.id.et_location);
        etDes = (EditText) findViewById(R.id.et_description);

        buttonback = (Button) findViewById(R.id.backbutton);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListCategoryActivity.class);
                startActivity(intent);
            }
        });

        buttonadd = (Button) findViewById(R.id.addbutton);
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryDAO cateDAO = new CategoryDAO(AddCategoryActivity.this);
                Category cate = new Category(etName.getText().toString(), etLoc.getText().toString(),
                        etDes.getText().toString());
                cateDAO.addCategory(cate);
                Intent intent = new Intent(getApplicationContext(), ListCategoryActivity.class);
                startActivity(intent);
//                Toast.makeText(AddCategoryActivity.this, cate.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}