package com.example.androidfinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class AddUserActivity extends AppCompatActivity {
    private Button btnBack;
    private Button btnSave;
    private ImageView uploadImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);


        getSupportActionBar().setTitle("Add User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnBack = (Button) findViewById(R.id.buttonBackCreateUser);
        btnSave = (Button) findViewById(R.id.buttonSaveUser);
        uploadImage = (ImageView) findViewById(R.id.uploadImage);

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(AddUserActivity.this)
                        .galleryOnly()
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewAdd(v);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        uploadImage.setImageURI(uri);
    }

    public void back(View view){
        Intent intent = new Intent(getApplicationContext(), ListUserActivity.class);
        startActivity(intent);
    }
    public void viewAdd(View view){
        Intent intent = new Intent(getApplicationContext(), AddUserActivity.class);
        startActivity(intent);
    }
}