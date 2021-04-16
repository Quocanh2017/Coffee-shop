package com.example.bundletesting.view;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.bundletesting.R;
import com.example.bundletesting.model.User;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.example.bundletesting.view.fragment.ProfileFragment;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;

public class ChangeProfile extends AppCompatActivity {

    private static final int REQUEST_CODE = 10;
    private ImageView imgPhoto;
    private EditText editName;
    private EditText editAccount;
    private EditText editPassword;
    private EditText editAddress;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_profile);

        editName = findViewById(R.id.edit_name);
        editAccount = findViewById(R.id.edit_account);
        editPassword = findViewById(R.id.edit_password);
        editAddress = findViewById(R.id.edit_address);

        imgPhoto = findViewById(R.id.change_profile_image);
        imgPhoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });

        button = findViewById(R.id.btn_edit_profile);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addProfile();
//                updateProfile();
                finish();
            }
        });
    }

    private void addProfile() {
        String sEditName = editName.getText().toString().trim();
        String sEditAccount = editAccount.getText().toString().trim();
        String sEditPassword = editPassword.getText().toString().trim();
        String sEditAddress = editAddress.getText().toString().trim();

        if(TextUtils.isEmpty(sEditName) || TextUtils.isEmpty(sEditAccount) || TextUtils.isEmpty(sEditPassword) || TextUtils.isEmpty(sEditAddress)){
            return;
        }

//        User user = new User(sEditName, sEditAccount, sEditPassword, sEditAddress);
        CoffeeDatabase.getInstance(this).userDao().setListUser(sEditName, sEditAccount, sEditPassword, sEditAddress);
        Toast.makeText(this, "change profile successfully",Toast.LENGTH_SHORT).show();

        editName.setText("");
        editAccount.setText("");
        editPassword.setText("");
        editAddress.setText("");
    }

    //request permission from user
    private void requestPermission() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                openImagePicker();
                Toast.makeText(ChangeProfile.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(ChangeProfile.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();
    }

    private void openImagePicker() {
        TedBottomPicker.OnImageSelectedListener listener = new TedBottomPicker.OnImageSelectedListener() {
            @Override
            public void onImageSelected(Uri uri) {
//                try{
//                    Uri bitmap = MediaStore.Images.Media.getContentUri(getContentResolver().toString(), uri);
//                    imgPhoto.setImageBitmap(bitmap);
//                }
//                catch( IOException e) {
//                    e.printStackTrace();
//                }
            }
        };

        TedBottomPicker.with(ChangeProfile.this)
                .setOnImageSelectedListener(listener)
                .show(listener);
    }
    }
