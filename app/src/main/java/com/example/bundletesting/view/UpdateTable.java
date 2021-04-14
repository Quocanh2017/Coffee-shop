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
import com.example.bundletesting.model.ChangeTable;
import com.example.bundletesting.model.database.CoffeeDatabase;

public class UpdateTable extends AppCompatActivity {

    private EditText editTextName;
    private Button button;

    private ChangeTable myChangeTable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_table);

        editTextName = findViewById(R.id.edit_table_name);
        button = findViewById(R.id.button_update_table);

        myChangeTable = (ChangeTable) getIntent().getExtras().get("change_table");
        if(myChangeTable != null){
            editTextName.setText(myChangeTable.getName());
        }
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                updateTable();
            }
        });
    }
    private void updateTable() {
        String sTableName = editTextName.getText().toString().trim();
        if(TextUtils.isEmpty(sTableName)){
            return;
        }
        // update table in db
        myChangeTable.setName(sTableName);

        CoffeeDatabase.getInstance(this).changeTableDAO().updateTable(myChangeTable);
        Toast.makeText(this,"update table successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
