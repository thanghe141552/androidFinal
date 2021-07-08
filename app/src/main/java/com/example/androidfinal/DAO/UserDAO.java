package com.example.androidfinal.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.androidfinal.DB.DatabaseHelper;
import com.example.androidfinal.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String tableName = "User";
    public static final String sql = "CREATE TABLE User (user_id int primary key autoincrement not null, " +
            "fullname text, phone text, email text, address text, image text);";

    public UserDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insert(User user) {
        ContentValues values = new ContentValues();
        values.put("fullname", user.getUserName());
        values.put("phone", user.getPhone());
        values.put("email", user.getEmail());
        values.put("address", user.getAddress());
        values.put("image", user.getImage());
        try {
            if (db.insert(tableName, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 1;
    }

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        Cursor c = db.query(tableName, null, null, null, null,
                null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            User user = new User();
            user.setId(c.getInt(0));
            user.setUserName(c.getString(1));
            user.setPhone(c.getString(2));
            user.setEmail(c.getString(3));
            user.setAddress(c.getString(4));
            user.setImage(c.getString(5));
            userList.add(user);
            c.moveToNext();
        }
        c.close();
        return userList;
    }

    public int delete(int userId) {
        int result = db.delete(tableName, "user_id=?", new String[]{String.valueOf(userId)});
        if (result == 0)
            return -1;
        return 1;
    }     //check login

    public int update(User user) {
        ContentValues values = new ContentValues();
        values.put("fullname", user.getUserName());
        values.put("phone", user.getPhone());
        values.put("email", user.getEmail());
        values.put("address", user.getAddress());
        values.put("image", user.getImage());
        int result = db.update(tableName, values, "user_id=?", new String[]{String.valueOf(user.getId())});
        if (result == 0) {
            return -1;
        }
        return 1;
    }
}
