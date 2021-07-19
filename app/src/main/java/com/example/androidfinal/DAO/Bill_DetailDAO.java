package com.example.androidfinal.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.androidfinal.DB.DatabaseHelper;
import com.example.androidfinal.Model.Bill_Detail;

import java.text.SimpleDateFormat;

public class Bill_DetailDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private Context context;
    public static final String TABLE_NAME = "BillDetail";
    public static final String SQL_HOA_DON_CHI_TIET ="CREATE TABLE BillDetail (bill_detail_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "bill_id INTEGER, quantity INTEGER, book_id INTEGER);";
    public Bill_DetailDAO(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public int inserBillDetail(Bill_Detail b){
        ContentValues values = new ContentValues();
        values.put("bill_detail_id",b.getBill_detail_id());
        values.put("bill_id",b.getBill_id());
        values.put("quantity",b.getQuantity());
        values.put("book_id",b.getBook_id());
        try {
            if(db.insert(TABLE_NAME,null,values)== -1){
                Toast.makeText(context,"Add fail",Toast.LENGTH_SHORT).show();
                return -1;
            }else{
                Toast.makeText(context,"Add successfully",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception ex){

        }
        return 1;
    }
    public int deleteDetailBillByID(int bill_id){
        int result = db.delete(TABLE_NAME,"bill_detail_id=?",new String[]{String.valueOf(bill_id)});
        if (result == 0)
            return -1;
        return 1;
    }
}
