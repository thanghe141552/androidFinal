package com.example.androidfinal.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidfinal.DB.DatabaseHelper;

public class StatisticDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbhelper;
    private Context context;

    public StatisticDAO(Context context) {
        dbhelper = new DatabaseHelper(context);
        this.context = context;
        db = dbhelper.getReadableDatabase();
    }

    public int getCategoryCount(){
        String countQuery = "SELECT * FROM Category;";
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;

    }
    public int getUserCount(){
        String countQuery = "SELECT * FROM User;";
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;

    }

    public int getBookCount(){
        String countQuery = "SELECT * FROM Book;";
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public String getBestSellerBook(){
        String bestsellerQuery = "SELECT book_name FROM Bill GROUP BY book_name ORDER BY SUM(quantity) DESC LIMIT 1;";
        Cursor cursor = db.rawQuery(bestsellerQuery, null);
        cursor.moveToFirst();
        if( cursor != null && cursor.moveToFirst() ) {
            String bestseller = cursor.getString(0);
            cursor.close();
            return bestseller;
        }
        return "None";
    }
    public int getTotalMoney(){
        String totalmoneyQuery = "SELECT SUM(total_price) FROM Bill ;";
        Cursor cursor = db.rawQuery(totalmoneyQuery, null);
        cursor.moveToFirst();
        int totalmoney = cursor.getInt(0);
        cursor.close();
        return totalmoney;
    }
}
