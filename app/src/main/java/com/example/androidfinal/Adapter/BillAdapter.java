package com.example.androidfinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidfinal.Model.User;
import com.example.androidfinal.R;

import java.util.List;

public class BillAdapter extends ArrayAdapter<User> {
    public BillAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_selecteed,parent,false);
        TextView txt_selected = convertView.findViewById(R.id.txt_selected);

        User user = this.getItem(position);
        if(user !=  null){
            txt_selected.setText(user.getUserName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable  View convertView, @NonNull  ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        TextView txt_user = convertView.findViewById(R.id.txt_dropdown_user);

        User user = this.getItem(position);
        if(user !=  null){
            txt_user.setText(user.getUserName());
        }
        return convertView;
    }
}
