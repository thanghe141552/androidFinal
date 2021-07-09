package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.Model.User;

public class EditUserActivity extends AppCompatActivity {
    private ImageView uploadImage;
    private TextView txtFullName;
    private TextView txtPhoneNumber;
    private TextView txtAddress;
    private TextView txtEmail;
    private int userId;
    private UserDAO userDAO;
    private Uri uri = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        uploadImage = (ImageView) findViewById(R.id.uploadImage);
        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtPhoneNumber = (TextView) findViewById(R.id.txtPhoneNumber);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        txtFullName.setText(b.getString("FULLNAME"));
        txtPhoneNumber.setText(b.getString("PHONE"));
        txtAddress.setText(b.getString("ADDRESS"));
        txtEmail.setText(b.getString("EMAIL"));
        uri = Uri.parse(b.getString("IMAGE"));
        userId = b.getInt("USERID");
        uploadImage.setImageURI(uri);
    }

    public void back(View view){
        Intent intent = new Intent(getApplicationContext(), ListUserActivity.class);
        startActivity(intent);
    }

    public void edit(View view) {
        userDAO = new UserDAO(EditUserActivity.this);
        User user = new User(userId,txtFullName.getText().toString(), txtPhoneNumber.getText().toString(),
                txtEmail.getText().toString(),txtAddress.getText().toString(), uri+"");
        Log.i("abc",user.toString());
        try {
            if (validateForm()){
                if (userDAO.update(user)) {
                    Toast.makeText(getApplicationContext(), "Edit user successfully", Toast.LENGTH_SHORT).show();
                    back(view);
                } else {
                    Toast.makeText(getApplicationContext(), "Edit user fail", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
    public boolean validateForm(){
        if (txtFullName.getText().length() == 0 || txtPhoneNumber.getText().length() == 0
                || txtEmail.getText().length() == 0 || txtAddress.getText().length()== 0
                || uri == null) {
            Toast.makeText(getApplicationContext(), "You must insert all", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}