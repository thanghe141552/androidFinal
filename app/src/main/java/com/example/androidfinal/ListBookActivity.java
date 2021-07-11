package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidfinal.Adapter.BookAdapter;
import com.example.androidfinal.DAO.BookDAO;
import com.example.androidfinal.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBookActivity extends AppCompatActivity {
private Button btnBack;
    private Button btnAdd;
    private ListView lvBook;
    private BookAdapter bookAdapter;
    private BookDAO bookDAO;
    public static List<Book> listBook = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);

        getSupportActionBar().setTitle("List Book");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lvBook =  (ListView) findViewById(R.id.lv_book);
        bookDAO = new BookDAO(ListBookActivity.this);
        listBook = bookDAO.getListBook();
        bookAdapter = new BookAdapter( this,listBook);
        lvBook.setAdapter(bookAdapter);



    }
    public void back(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void viewAdd(View view){
        Intent intent = new Intent(getApplicationContext(), AddBookActivity.class);
        startActivity(intent);
    }
}