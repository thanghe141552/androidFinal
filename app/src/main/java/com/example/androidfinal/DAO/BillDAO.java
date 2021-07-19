package com.example.androidfinal.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.androidfinal.DB.DatabaseHelper;
import com.example.androidfinal.Model.Bill;
import com.example.androidfinal.Model.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private Context context;
    public static final String TABLE_NAME = "Bill";
    public static final String SQL_Bill ="CREATE TABLE Bill (bill_id INTEGER primary key autoincrement , date date, user_name text" +
            ", quantity number, book_name text, total_price number, paid boolean);" ;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public BillDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        this.context  = context;
        db = dbHelper.getWritableDatabase();
    }
    public boolean insertBill(Bill b){
        ContentValues values = new ContentValues();
        values.put("bill_id",b.getBill_id());
        values.put("date",sdf.format(b.getDate()));
        values.put("user_name",b.getUser_name());
        values.put("quantity",b.getQuantity());
        values.put("book_name",b.getBook_name());
        values.put("total_price",b.getTotal_price());
        values.put("paid",b.isPaid());
        long result = db.insert(TABLE_NAME,null,values);
        if(result == -1){
            Toast.makeText(context,"Fail",Toast.LENGTH_SHORT).show();
            return false;
        }else{
            Toast.makeText(context,"Add successfully",Toast.LENGTH_SHORT).show();
            return true;
        }
    }
    public List<Bill> getAllBill() throws ParseException {
        List<Bill> listBill = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            Bill bill = new Bill();
            bill.setBill_id(c.getInt(0));
            bill.setDate(sdf.parse(c.getString(1)));
            bill.setUser_name(c.getString(2));
            bill.setQuantity(c.getInt(3));
            bill.setBook_name(c.getString(4));
            bill.setTotal_price(c.getDouble(5));
            if(c.getInt(6)>0){
                bill.setPaid(true);
            }else bill.setPaid(false);
            listBill.add(bill);
            c.moveToNext();
        }
        c.close();
        return listBill;
    }
//    public int updateBill(Bill b){
//        ContentValues values = new ContentValues();
//        values.put("bill_id",b.getBill_id());
//        values.put("date",b.getDate().toString());
//        int result = db.update(TABLE_NAME,values,"bill_id=?", new String[]{String.valueOf(b.getBill_id())});
//        if (result == 0){
//            return -1;
//        }
//        return 1;
//    }
    public int updateStatusPaidBill(Bill b){
        ContentValues values = new ContentValues();
        values.put("paid",b.isPaid());
        int result = db.update(TABLE_NAME,values,"bill_id=?", new String[]{String.valueOf(b.getBill_id())});
        if (result == 0){
            return -1;
        }
        return 1;
    }
    //delete
    public int deleteBillByID(int bill_id){
        int result = db.delete(TABLE_NAME,"bill_id=?",new String[]{String.valueOf(bill_id)});
        if (result == 0)
            return -1;
        return 1;
    }
}
