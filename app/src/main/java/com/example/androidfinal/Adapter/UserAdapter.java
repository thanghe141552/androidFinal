package com.example.androidfinal.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.EditUserActivity;
import com.example.androidfinal.Model.User;
import com.example.androidfinal.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter implements Filterable {
    List<User> userList;
    List<User> userListBeforeFilter;
    public Activity activity;
    public LayoutInflater inflater;
    UserDAO userDAO;

    public UserAdapter(Activity context, List<User> userList) {
        super();
        this.activity = context;
        this.userList = userList;
        this.userListBeforeFilter = userList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        userDAO = new UserDAO(context);
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String search = constraint.toString();
                if(search.isEmpty()){
                    userList = userListBeforeFilter;
                }else{
                    List<User> userFilter = new ArrayList<>();
                    for (User u: userListBeforeFilter) {
                        if(u.getUserName().toLowerCase().contains(search)){
                            userFilter.add(u);
                        }
                    }
                    userList = userFilter;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = userList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                userList = (List<User>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public static class ViewHolder {
        ImageView imgUser;
        TextView txtName;
        TextView txtPhone;
        ImageView imgDelete;
        ImageView imgEdit;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_user, null);
            holder.imgUser = (ImageView) convertView.findViewById(R.id.imageUser);
            holder.txtName = (TextView) convertView.findViewById(R.id.userName);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.userPhone);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.btn_delete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userDAO.delete(userList.get(position).getId());
                    userList.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(activity.getApplicationContext(), "Delete successfully", Toast.LENGTH_SHORT).show();
                }
            });
            holder.imgEdit = (ImageView) convertView.findViewById(R.id.imageEdit);
            holder.imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, EditUserActivity.class);
                    Bundle b = new Bundle();
                    b.putString("ADDRESS", userList.get(position).getAddress());
                    b.putString("PHONE", userList.get(position).getPhone());
                    b.putString("FULLNAME", userList.get(position).getUserName());
                    b.putString("EMAIL", userList.get(position).getEmail());
                    b.putString("IMAGE", userList.get(position).getImage());
                    b.putInt("USERID", userList.get(position).getId());
                    intent.putExtras(b);
                    activity.startActivity(intent);
                }
            });
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        User user = (User) userList.get(position);
        holder.imgUser.setImageURI(Uri.parse(user.getImage()));
        holder.txtName.setText(user.getUserName());
        holder.txtPhone.setText(user.getPhone());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<User> items) {
        this.userList = items;
        notifyDataSetChanged();
    }
}
