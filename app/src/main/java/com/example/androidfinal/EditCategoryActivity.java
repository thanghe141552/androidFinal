package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfinal.DAO.CategoryDAO;
import com.example.androidfinal.Model.Category;

public class EditCategoryActivity extends AppCompatActivity {

    private TextView etName, etLocation, etDescription;
    private Button buttonsave, buttonback;
    private int code;
    private CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_category);

        etName = findViewById(R.id.et_editname);
        etLocation = findViewById(R.id.et_editlocation);
        etDescription =  findViewById(R.id.et_editdescription);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        etName.setText(b.getString("catName"));
        etLocation.setText(b.getString("catLoc"));
        etDescription.setText(b.getString("catDes"));
        code = b.getInt("catCode");

        buttonback = findViewById(R.id.btn_back);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListCategoryActivity.class);
                startActivity(intent);
            }
        });

        buttonsave = findViewById(R.id.btn_save);
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryDAO = new CategoryDAO(EditCategoryActivity.this);
                Category category = new Category(code, etName.getText().toString(), etLocation.getText().toString(), etDescription.getText().toString());
                try{
                    if(validateForm()){
                        if(categoryDAO.editCategory(category)){
                            Toast.makeText(getApplicationContext(), "Update successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ListCategoryActivity.class);
                            startActivity(intent);
                        }
                    }
                }catch (Exception e){
                    Log.e("ERROR", e.toString());
                }
            }
        });
    }

    public boolean validateForm(){
        if (etName.getText().length() == 0 || etLocation.getText().length() == 0 || etDescription.getText().length() == 0){
            Toast.makeText(getApplicationContext(), "You must enter all the text", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}