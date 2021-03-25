package com.example.bundletesting.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bundletesting.R;

public class sign_up extends AppCompatActivity {

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
                    Toast.makeText(getApplicationContext(),"Sign up successfull",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
