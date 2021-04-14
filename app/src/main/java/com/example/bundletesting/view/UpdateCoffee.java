package com.example.bundletesting.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bundletesting.R;
import com.example.bundletesting.model.ChangeCoffee;
import com.example.bundletesting.model.database.CoffeeDatabase;

public class UpdateCoffee extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextDes;
    private EditText editTextPrice;
    private Button button;

    private ChangeCoffee myChangeCoffee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_coffee);

        editTextName = findViewById(R.id.update_name_coffee);
        editTextDes = findViewById(R.id.update_des_coffee);
        editTextPrice = findViewById(R.id.update_price_coffee);
        button = findViewById(R.id.button_update_coffee);

        myChangeCoffee = (ChangeCoffee) getIntent().getExtras().get("change_coffee");
        if(myChangeCoffee != null){
            editTextName.setText(myChangeCoffee.getName());
            editTextDes.setText(myChangeCoffee.getDescription());
            editTextPrice.setText(myChangeCoffee.getPrice());
        }

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                updateCoffee();
            }
        });
    }
    private void updateCoffee() {
        String sCoffeeName = editTextName.getText().toString().trim();
        String sCoffeeDes = editTextDes.getText().toString().trim();
        String sCoffeePrice = editTextPrice.getText().toString().trim();
        if(TextUtils.isEmpty(sCoffeeName) || TextUtils.isEmpty(sCoffeeDes) || TextUtils.isEmpty(sCoffeePrice)){
            return;
        }
        // update table in db
        myChangeCoffee.setName(sCoffeeName);
        myChangeCoffee.setDescription(sCoffeeDes);
        myChangeCoffee.setPrice(sCoffeePrice);

        CoffeeDatabase.getInstance(this).changeCoffeeDAO().updateCoffee(myChangeCoffee);
        Toast.makeText(this,"update coffee successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
