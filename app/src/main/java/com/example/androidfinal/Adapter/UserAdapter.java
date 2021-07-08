package com.example.androidfinal.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.Model.User;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    List<User> userList;
    public Activity activity;
    public LayoutInflater inflater;
    UserDAO userDAO;

    public UserAdapter(Activity context, List<User> userList) {
        super();
        this.activity = context;
        this.userList = userList;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }



//
//    public static class ViewHolder {
//        ImageView img;
//        TextView txtName;
//        TextView txtPhone;
//        ImageView imgDelete;
//    }
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        if(convertView==null){
//            holder = new ViewHolder();
//            convertView = inflater.inflate(R.layout.item_nguoi_dung, null);
//            holder.img = (ImageView) convertView.findViewById(R.id.ivIcon);
//            holder.txtName = (TextView) convertView.findViewById(R.id.tvName);
//            holder.txtPhone = (TextView) convertView.findViewById(R.id.tvPhone);
//            holder.imgDelete = (ImageView)convertView.findViewById(R.id.ivDelete);
//            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    nguoiDungDAO.deleteNguoiDungByID(arrNguoiDung.get(position).getUserName());
//                    arrNguoiDung.remove(position);
//                    notifyDataSetChanged();
//                }
//            });
//            convertView.setTag(holder);
//        }
//        else
//            holder=(ViewHolder)convertView.getTag();
//        NguoiDung _entry = (NguoiDung) arrNguoiDung.get(position);
//        if (position % 3 ==0) {
//            holder.img.setImageResource(R.drawable.emone);
//        }else if (position % 3 == 1){
//            holder.img.setImageResource(R.drawable.emtwo);
//        }else {
//            holder.img.setImageResource(R.drawable.emthree);
//        }
//        holder.txtName.setText(_entry.getHoTen());
//        holder.txtPhone.setText(_entry.getPhone());
//        return convertView;
//    }
//    @Override     public void notifyDataSetChanged() {
//        super.notifyDataSetChanged();
//    }
//    public void changeDataset(List<NguoiDung> items){
//        this.arrNguoiDung = items;
//        notifyDataSetChanged();
//    }
}
