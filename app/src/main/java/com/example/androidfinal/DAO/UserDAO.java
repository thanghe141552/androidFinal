package com.example.androidfinal.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidfinal.DB.DatabaseHelper;

public class UserDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public UserDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
}
