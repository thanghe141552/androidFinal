package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidfinal.DAO.UserDAO;

public class DetailUserActivity extends AppCompatActivity {
    private ImageView uploadImage;
    private TextView txtFullName;
    private TextView txtPhoneNumber;
    private TextView txtAddress;
    private TextView txtEmail;
    private UserDAO userDAO;
    private Uri uri = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        getSupportActionBar().setTitle("Detail User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        uploadImage.setImageURI(Uri.parse(b.getString("IMAGE")));
    }
}