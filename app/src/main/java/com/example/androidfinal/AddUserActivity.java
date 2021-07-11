package com.example.androidfinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.Model.User;
import com.github.dhaval2404.imagepicker.ImagePicker;


public class AddUserActivity extends AppCompatActivity {
    private Button btnBack;
    private Button btnSave;
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
        setContentView(R.layout.activity_add_user);


        getSupportActionBar().setTitle("Add User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnBack = (Button) findViewById(R.id.buttonBackCreateUser);
        btnSave = (Button) findViewById(R.id.buttonEditUser);
        uploadImage = (ImageView) findViewById(R.id.uploadImage);
        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtPhoneNumber = (TextView) findViewById(R.id.txtPhoneNumber);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(AddUserActivity.this)
                        .galleryOnly()
//                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                        //                        .crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
//                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        this.uri = uri;
        uploadImage.setImageURI(uri);
        Log.i(uri+"","");
    }

    public void back(View view){
        Intent intent = new Intent(getApplicationContext(), ListUserActivity.class);
        startActivity(intent);
    }

    public void insert(View view) {
        userDAO = new UserDAO(AddUserActivity.this);
        User user = new User(txtFullName.getText().toString(), txtPhoneNumber.getText().toString(),
                txtEmail.getText().toString(),txtAddress.getText().toString(), uri+"");

        try {
            if (validateForm()){
                if (userDAO.insert(user)) {
                    Toast.makeText(getApplicationContext(), "Add user successfully", Toast.LENGTH_SHORT).show();
                    back(view);
                } else {
                    Toast.makeText(getApplicationContext(), "Add user fail", Toast.LENGTH_SHORT).show();
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