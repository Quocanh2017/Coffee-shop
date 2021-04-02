package com.example.bundletesting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bundletesting.homepage.HomePage;
import com.example.bundletesting.login.Login;
import com.example.bundletesting.login.SignUp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button bt, bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        Activity context = new Activity();

        bt = (Button) findViewById(R.id.bt);
        bt1 = (Button) findViewById(R.id.bt_1);
        bt2 = (Button) findViewById(R.id.bt_2);

        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentLogin = new Intent(MainActivity.this , Login.class);
                startActivity(intentLogin);
            }
        });


        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentLogin = new Intent(MainActivity.this , SignUp.class);
                startActivity(intentLogin);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentLogin = new Intent(MainActivity.this , HomePage.class);
                startActivity(intentLogin);
            }
        });

    }

}