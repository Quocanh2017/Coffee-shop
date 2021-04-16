package com.example.bundletesting.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bundletesting.R;
import com.example.bundletesting.model.User;
import com.example.bundletesting.model.database.CoffeeDatabase;

public class SignUp extends AppCompatActivity {

    Button btn1;

    EditText edit1, edit2, edit3, edit4;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        signUp();
    }

    private void signUp(){
        btn1 = (Button)findViewById(R.id.button_su);

        edit1 = (EditText)findViewById(R.id.editText1_su);
        edit2 = (EditText)findViewById(R.id.editText2_su);
        edit3 = (EditText)findViewById(R.id.editText3_su);
        edit4 = (EditText)findViewById(R.id.editText4_su);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(edit1.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter all infomation",Toast.LENGTH_SHORT).show();
                }
                else if(edit2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter all infomation",Toast.LENGTH_SHORT).show();
                }
                else if(edit3.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter all infomation",Toast.LENGTH_SHORT).show();
                }
                else if(edit4.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter all infomation",Toast.LENGTH_SHORT).show();
                }
                else{
                    addUser();
                    Intent intent = new Intent(SignUp.this, HomePage.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Sign up successfull",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addUser(){
        String sUserName = edit1.getText().toString().trim();
        String sAccount = edit2.getText().toString().trim();
        String sPassword = edit3.getText().toString().trim();
        String sRetypePassword = edit4.getText().toString().trim();

        if (TextUtils.isEmpty(sUserName) || TextUtils.isEmpty(sAccount) || TextUtils.isEmpty(sPassword) || TextUtils.isEmpty(sRetypePassword)){
            return;
        }
        User user = new User(sUserName, sAccount, sPassword, "Ha Noi");
        CoffeeDatabase.getInstance(this).userDao().insertUser(user);
        Toast.makeText(this, "Add user successfully", Toast.LENGTH_SHORT).show();

        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
        edit4.setText("");
    }
}
