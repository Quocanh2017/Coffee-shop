package com.example.bundletesting.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bundletesting.R;

public class Login extends Activity {

    Button btn1;
    EditText edit1, edit2;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btn1 = (Button)findViewById(R.id.button1);

        edit1 = (EditText)findViewById(R.id.editText1);
        edit2 = (EditText)findViewById(R.id.editText2);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(edit1.getText().toString().equals("admin") && edit2.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),"Login successfull", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login fail", Toast.LENGTH_SHORT).show();
                    counter++;
                    if(counter > 3){
                        btn1.setEnabled(false);
                    }
                }
            }
        });
    }
}
