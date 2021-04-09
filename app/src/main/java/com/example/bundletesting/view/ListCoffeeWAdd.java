package com.example.bundletesting.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.bundletesting.R;
import com.example.bundletesting.model.Coffee;

public class ListCoffeeWAdd extends AppCompatActivity {

    private Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coffee_w_add);

        coffee = (Coffee) getIntent().getExtras().get("Coffee");

        coffee.getName();

        Toast.makeText(getApplicationContext(), coffee.toString(), Toast.LENGTH_SHORT);

    }
}