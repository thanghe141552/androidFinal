package com.example.androidfinal.DB;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidfinal.DAO.BillDAO;
import com.example.androidfinal.DAO.BookDAO;
import com.example.androidfinal.DAO.CategoryDAO;
import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.Model.Category;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "BookManager";
    public static final int VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDAO.sql);
        db.execSQL(BookDAO.SQL_Book);
        db.execSQL(CategoryDAO.createTableStatement);
        db.execSQL(BillDAO.SQL_Bill);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+UserDAO.tableName);
        db.execSQL("Drop table if exists "+BookDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+CategoryDAO.CATEGORY_TABLE);
        db.execSQL("Drop table if exists "+BillDAO.TABLE_NAME);
        onCreate(db);
    }
}