package com.example.androidfinal.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.androidfinal.DB.DatabaseHelper;
import com.example.androidfinal.Model.Bill_Detail;

import java.text.SimpleDateFormat;

public class Bill_DetailDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "BillDetail";
    public static final String SQL_HOA_DON_CHI_TIET ="CREATE TABLE BillDetail (bill_detail_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "quantity int, book_id int , bill_id int);";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public Bill_DetailDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public int inserBillDetail(Bill_Detail b){
        ContentValues values = new ContentValues();
        values.put("bill_id",b.getBill().getBill_id());
        values.put("book_id",b.getBook().getCode());
        values.put("quantity",b.getQuantity());
        try {
            if(db.insert(TABLE_NAME,null,values)== -1){
                return -1;
            }
        }catch (Exception ex){

        }
        return 1;
    }
}
