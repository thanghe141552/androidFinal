package com.example.androidfinal.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.androidfinal.Model.Book;
import com.example.androidfinal.DAO.CategoryDAO;
import com.example.androidfinal.Model.Category;
import com.example.androidfinal.Model.User;
import com.example.androidfinal.R;

import java.util.List;

public class BookDropdownAdapter extends BaseAdapter {
    private Activity activity;
    private List<Book> listBook;
    public LayoutInflater inflater;
    CategoryDAO categoryDAO;

    public BookDropdownAdapter(Activity context, List<Book> listBook) {
        super();
        this.activity = context;
        this.listBook = listBook;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        categoryDAO = new CategoryDAO(context);
    }

    @Override
    public int getCount() {
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        return listBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_selected,parent,false);
        TextView txt_selected = convertView.findViewById(R.id.txt_book_selected);

        Book book = (Book) this.getItem(position);
        if(book !=  null){
            txt_selected.setText(book.getName());
        }
        return convertView;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false);
        TextView txt_category = convertView.findViewById(R.id.txt_dropdown_book);
        Book book = (Book) this.getItem(position);
        if(book !=  null){
            txt_category.setText(book.getName());
        }
        return convertView;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

}
