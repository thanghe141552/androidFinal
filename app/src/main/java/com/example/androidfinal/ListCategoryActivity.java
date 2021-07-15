package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidfinal.Adapter.CategoryAdapter;
import com.example.androidfinal.DAO.CategoryDAO;
import com.example.androidfinal.Model.Category;

import java.util.ArrayList;
import java.util.List;

public class ListCategoryActivity extends AppCompatActivity {

    private Button backButton;
    private Button addButton;
    private ListView lvCategory;
    private CategoryAdapter categoryAdapter;
    private CategoryDAO categoryDAO;

    private static List<Category> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);

        getSupportActionBar().setTitle("Category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvCategory = (ListView) findViewById(R.id.listcategoryView);
        categoryDAO = new CategoryDAO(ListCategoryActivity.this);
        categoryList = categoryDAO.showCategory();
        categoryAdapter = new CategoryAdapter(this, categoryList);
        lvCategory.setAdapter(categoryAdapter);
        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListCategoryActivity.this, DetailCategoryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("catName", categoryList.get(position).getCateName());
                bundle.putString("catLoc", categoryList.get(position).getCatePos());
                bundle.putString("catDes", categoryList.get(position).getCateDes());
                bundle.putInt("catCode", categoryList.get(position).getCateCode());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        backButton = (Button) findViewById(R.id.cateBackbutton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        addButton = (Button) findViewById(R.id.cateAddbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddCategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}