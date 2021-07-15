package com.example.androidfinal.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.androidfinal.DB.DatabaseHelper;
import com.example.androidfinal.Model.Category;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class CategoryDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbhelper;
    private Context context;
    public static final String CATEGORY_TABLE = "Category";

    public static final String createTableStatement = "CREATE TABLE " + CATEGORY_TABLE + " (catCode INTEGER PRIMARY KEY autoincrement, catName TEXT, catDes TEXT, catLoc TEXT);";

    public CategoryDAO(Context context) {
        dbhelper = new DatabaseHelper(context);
        this.context = context;
        db = dbhelper.getWritableDatabase();
    }

    public void addCategory(Category category){
        ContentValues values = new ContentValues();
        values.put("catName", category.getCateName());
        values.put("catDes", category.getCateDes());
        values.put("catLoc", category.getCatePos());
        long add = db.insert(CATEGORY_TABLE, null, values);
        if(add == -1){
            Toast.makeText(context, "Add failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Add Successful", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Category>  showCategory(){
        List<Category> categoryList = new ArrayList<>();
        Cursor c = db.query(CATEGORY_TABLE, null, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Category cate = new Category();
            cate.setCateCode(c.getInt(0));
            cate.setCateName(c.getString(1));
            cate.setCatePos(c.getString(2));
            cate.setCateDes(c.getString(3));
            categoryList.add(cate);
            Log.i("arrlist:", categoryList.toString());
            c.moveToNext();
        }
        c.close();
        return categoryList;
    }

    public int deleteCategory(int category_id){
        int result = db.delete(CATEGORY_TABLE, "catCode=?", new String[]{valueOf(category_id)});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public boolean editCategory(Category category){
        ContentValues values = new ContentValues();
        values.put("catName", category.getCateName());
        values.put("catDes", category.getCateDes());
        values.put("catLoc", category.getCatePos());

        int result = db.update(CATEGORY_TABLE, values, "catCode=?", new String[]{String.valueOf(category.getCateCode())});
        if(result < 0){
            return false;
        }
        return true;
    }
}
