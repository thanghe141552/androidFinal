package com.example.androidfinal.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.androidfinal.DB.DatabaseHelper;
import com.example.androidfinal.Model.Book;
import com.example.androidfinal.Model.User;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private Context context;
    public static final String TABLE_NAME = "Book";
    public static final String SQL_Book ="CREATE TABLE Book (code INTEGER primary key autoincrement , book_name TEXT, " +
            "quantity integer," +
            "category text, price double);";
    public BookDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        this.context  = context;
        db = dbHelper.getWritableDatabase();
    }

    public void insertBook(Book book){
        ContentValues values = new ContentValues();

        values.put("book_name",book.getName());
        values.put("quantity",book.getQuantity());
        values.put("category",book.getCategory());
        values.put("price",book.getPrice());

        long result = db.insert(TABLE_NAME,null,values);
        if(result == -1){
            Toast.makeText(context,"Fail",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Add successfully",Toast.LENGTH_SHORT).show();

        }

    }
    //getAll
    public List<Book> getListBook(){
        List<Book> listBook = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            Book b = new Book();
            b.setCode(c.getInt(0));
           b.setName(c.getString(1));
           b.setQuantity(c.getInt(2));
           b.setCategory(c.getString(3));
           b.setPrice(c.getDouble(4));
           listBook.add(b);
            Log.i("arrlist: ", listBook.toString());

//            Log.d("//=====",b.toString());
            c.moveToNext();
        }
        c.close();
        return listBook;
   }
    public int delete(int book_id) {
        int result = db.delete(TABLE_NAME, "code=?", new String[]{String.valueOf(book_id)});
        if (result == 0)
            return -1;
        return 1;
    }
    public boolean update(Book book) {
        ContentValues values = new ContentValues();
        values.put("book_name",book.getName());
        values.put("quantity",book.getQuantity());
        values.put("category",book.getCategory());
        values.put("price",book.getPrice());
        int result = db.update(TABLE_NAME, values, "code=?", new String[]{String.valueOf(book.getCode())});
        if (result < 0) {
            return false;
        }
        return true;
    }
}
