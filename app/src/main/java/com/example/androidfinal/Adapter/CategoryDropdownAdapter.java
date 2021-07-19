package com.example.androidfinal.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidfinal.DAO.CategoryDAO;
import com.example.androidfinal.EditCategoryActivity;
import com.example.androidfinal.Model.Category;
import com.example.androidfinal.Model.User;
import com.example.androidfinal.R;

import java.util.List;

public class CategoryDropdownAdapter extends BaseAdapter {
    private Activity activity;
    private List<Category> listCate;
    public LayoutInflater inflater;
    CategoryDAO categoryDAO;

    public CategoryDropdownAdapter(Activity context, List<Category> listCate) {
        super();
        this.activity = context;
        this.listCate = listCate;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        categoryDAO = new CategoryDAO(context);
    }

    @Override
    public int getCount() {
        return listCate.size();
    }

    @Override
    public Object getItem(int position) {
        return listCate.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_selected,parent,false);
        TextView txt_selected = convertView.findViewById(R.id.txt_category_selected);

        Category category = (Category) this.getItem(position);
        if(category !=  null){
            txt_selected.setText(category.getCateName());
        }
        return convertView;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        TextView txt_category = convertView.findViewById(R.id.txt_dropdown_category);

        Category category = (Category) this.getItem(position);
        if(category !=  null){
            txt_category.setText(category.getCateName());
        }
        return convertView;
    }
}
