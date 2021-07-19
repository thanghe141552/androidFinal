package com.example.androidfinal.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfinal.DAO.BillDAO;
import com.example.androidfinal.Model.Bill;
import com.example.androidfinal.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class BillAdapter extends BaseAdapter {
    List<Bill> billList;
    public Activity activity;
    public LayoutInflater inflater;
    public BillDAO billDAO;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public BillAdapter(Activity context, List<Bill> bill_detailList) {
        super();
        this.activity = context;
        this.billList = bill_detailList;
        this.billDAO = new BillDAO(context);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return billList.size();
    }

    @Override
    public Object getItem(int position) {
        return billList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public static class ViewHolder {
        TextView txtBillUserName;
        TextView txtDate;
        ImageView imgDelete;
        ImageView imgPaid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BillAdapter.ViewHolder holder;
        if (convertView == null) {
            holder = new BillAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_bill, null);
            holder.txtBillUserName = (TextView) convertView.findViewById(R.id.bill_user_name);
            holder.txtDate = (TextView) convertView.findViewById(R.id.bill_date);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.btn_bill_delete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    billDAO.deleteBillByID(billList.get(position).getBill_id());
                    billList.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(activity.getApplicationContext(), "Delete Bill successfully", Toast.LENGTH_SHORT).show();
                }
            });
            holder.imgPaid = (ImageView) convertView.findViewById(R.id.btn_bill_update_paid);
            holder.imgPaid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    billList.get(position).setPaid(true);
                    billDAO.updateStatusPaidBill(billList.get(position));
                    notifyDataSetChanged();

                    holder.imgPaid.setImageResource(R.drawable.paid_done);
                    Toast.makeText(activity.getApplicationContext(), "Update Paid Bill successfully", Toast.LENGTH_SHORT).show();
                }
            });
            convertView.setTag(holder);
        } else
            holder = (BillAdapter.ViewHolder) convertView.getTag();
        Bill bill = (Bill) billList.get(position);
        holder.txtBillUserName.setText(bill.getUser_name());
        holder.txtDate.setText(sdf.format(bill.getDate()));
        if(bill.isPaid()){
            holder.imgPaid.setImageResource(R.drawable.paid_done);
        }
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<Bill> items) {
        this.billList = items;
        notifyDataSetChanged();
    }
}
