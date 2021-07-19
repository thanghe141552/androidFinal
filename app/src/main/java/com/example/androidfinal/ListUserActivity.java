package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.androidfinal.Adapter.UserAdapter;
import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.Model.User;

import java.util.List;

public class ListUserActivity extends AppCompatActivity {
    private Button btnBack;
    private Button btnAdd;
    private ListView listViewUser;
    private UserDAO userDAO;
    private List<User> userList;
    private UserAdapter userAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        getSupportActionBar().setTitle("List User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnBack = (Button) findViewById(R.id.buttonBackUser);
        btnAdd = (Button) findViewById(R.id.buttonAddUser);
        listViewUser = (ListView) findViewById(R.id.listUser);
        searchView = (SearchView) findViewById(R.id.search_view);
        userDAO = new UserDAO(ListUserActivity.this);
        userList = userDAO.getAll();
        userAdapter = new UserAdapter(this, userList);
        listViewUser.setAdapter(userAdapter);
        listViewUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListUserActivity.this, DetailUserActivity.class);
                Bundle b = new Bundle();
                b.putString("ADDRESS", userList.get(position).getAddress());
                b.putString("PHONE", userList.get(position).getPhone());
                b.putString("FULLNAME", userList.get(position).getUserName());
                b.putString("EMAIL", userList.get(position).getEmail());
                b.putString("IMAGE", userList.get(position).getImage());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userAdapter.getFilter().filter(newText);
                Log.i("TAGGGGG", "onQueryTextChange: "+ newText);
                return false;
            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void viewAdd(View view) {
        Intent intent = new Intent(getApplicationContext(), AddUserActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        userList.clear();
        userList = userDAO.getAll();
        userAdapter.changeDataset(userDAO.getAll());
    }
}