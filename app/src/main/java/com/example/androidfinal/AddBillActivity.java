package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidfinal.Adapter.BillAdapter;
import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.Model.User;

import java.util.ArrayList;
import java.util.List;

public class AddBillActivity extends AppCompatActivity {
    private Spinner spin_user;
    private BillAdapter billAdapter;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        spin_user = findViewById(R.id.spin_user);
        billAdapter = new BillAdapter(this, R.layout.item_user_selecteed, getListUser());
        spin_user.setAdapter(billAdapter);
        spin_user.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AddBillActivity.this, billAdapter.getItem(position).getUserName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<User> getListUser() {
        List<User> listUser = new ArrayList<>();
        UserDAO userDAO = new UserDAO(AddBillActivity.this);
        List<User> users = userDAO.getAll();
        for (User u: users) {
            listUser.add(u);
        }
        Log.i("", "getListUserName: " + listUser);
        return listUser;
    }

}