package com.example.androidfinal.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfinal.DAO.BookDAO;
import com.example.androidfinal.EditBookActivity;
import com.example.androidfinal.ListBookActivity;
import com.example.androidfinal.MainActivity;
import com.example.androidfinal.Model.Book;
import com.example.androidfinal.Model.User;
import com.example.androidfinal.R;

import java.util.List;

public class BookAdapter extends BaseAdapter    {
private Activity context;
    private List<Book> listBook;
    public LayoutInflater inflater;
    private Activity activity;

    BookDAO bookDAO;
    public BookAdapter(Activity context, List<Book> listBook) {
        super();
        this.activity = context;
        this.listBook = listBook;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        bookDAO = new BookDAO(context);
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
    public static class ViewHolder {
        ImageView imgIconBook;
        TextView txtBookName;
        TextView txtBookCategory;
        ImageView imgDelete;
        ImageView imgUpdate;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.book_item, null);
            holder.imgIconBook = convertView.findViewById(R.id.imageView2);
            holder.txtBookName = convertView.findViewById(R.id.txt_name);
            holder.txtBookCategory = convertView.findViewById(R.id.txt_category);

            holder.imgDelete = convertView.findViewById(R.id.btn_delete);
            holder.imgUpdate = convertView.findViewById(R.id.btn_update);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bookDAO.delete(listBook.get(position).getCode());
                    listBook.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
            holder.imgUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, EditBookActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("book_name",listBook.get(position).getName());
                    bundle.putInt("quantity",listBook.get(position).getQuantity());
                    bundle.putString("category",listBook.get(position).getCategory());
                    bundle.putDouble("price",listBook.get(position).getPrice());
                    bundle.putInt("code",listBook.get(position).getCode());
                    intent.putExtras(bundle);
                    activity.startActivity(intent);
                }
            });
        }else
            holder = (BookAdapter.ViewHolder) convertView.getTag();
            Book book = (Book) listBook.get(position);

            holder.txtBookName.setText(book.getName());
            holder.txtBookCategory.setText(book.getCategory());
            return convertView;

    }
}
