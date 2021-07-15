package com.example.androidfinal.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidfinal.DAO.CategoryDAO;
import com.example.androidfinal.EditCategoryActivity;
import com.example.androidfinal.Model.Category;
import com.example.androidfinal.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private Activity activity;
    private List<Category> listCate;
    public LayoutInflater inflater;
    CategoryDAO categoryDAO;

    public CategoryAdapter(Activity context, List<Category> listCate) {
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

    public static class ViewHolder{
        ImageView ivcateIcon;
        TextView tvcateName;
        TextView tvcateLocation;
        ImageView ivEdit;
        ImageView ivDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_category,null);
            holder.ivcateIcon = convertView.findViewById(R.id.iv_photo);
            holder.ivEdit = convertView.findViewById(R.id.iv_edit);
            holder.ivDelete = convertView.findViewById(R.id.iv_delete);
            holder.tvcateName = convertView.findViewById(R.id.tv_name);
            holder.tvcateLocation = convertView.findViewById(R.id.tv_location);
            holder.ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    categoryDAO.deleteCategory(listCate.get(position).getCateCode());
                    listCate.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
            holder.ivEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, EditCategoryActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("catName", listCate.get(position).getCateName());
                    bundle.putString("catLoc", listCate.get(position).getCatePos());
                    bundle.putString("catDes", listCate.get(position).getCateDes());
                    bundle.putInt("catCode", listCate.get(position).getCateCode());
                    intent.putExtras(bundle);
                    activity.startActivity(intent);
                }
            });


        } else
            holder = (CategoryAdapter.ViewHolder) convertView.getTag();
            Category category = (Category)listCate.get(position);
            holder.tvcateName.setText(category.getCateName());
            holder.tvcateLocation.setText(category.getCatePos());
            return convertView;
    }
}
