package com.example.bundletesting.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bundletesting.view.Constants;
import com.example.bundletesting.R;
import com.example.bundletesting.view.SharePrefers;
import com.example.bundletesting.model.User;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.example.bundletesting.model.database.UserDAO;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Login extends AppCompatActivity {

    Button btn1;
    EditText edit1, edit2;
    TextView textView;

    User user;
    UserDAO userDAO;

    private LoginButton mBtnLoginFacebook;
    private CallbackManager mCallbackManager;
    private static final String EMAIL = "email";


    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btn1 = (Button) findViewById(R.id.button1);

        edit1 = (EditText) findViewById(R.id.editText1);
        edit2 = (EditText) findViewById(R.id.editText2);

        textView = (TextView) findViewById(R.id.tv_create_account);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edit1.getText().toString();
                String pw = edit2.getText().toString();
                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(pw)) {
                    if (getListUser(userName, pw)) {
                        Toast.makeText(getApplicationContext(), "Login successfull", Toast.LENGTH_SHORT).show();
                        SharedPreferences preferences = SharePrefers.getInstance(Login.this);
                        preferences.edit().putString(Constants.USER_NAME, userName).apply();
                        preferences.edit().putString(Constants.PASSWORD, pw).apply();
                        Intent intent = new Intent(Login.this, HomePage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Login fail", Toast.LENGTH_SHORT).show();
                        counter++;
                        if (counter > 3) {
                            btn1.setEnabled(false);
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "input all data to edit text", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mCallbackManager = CallbackManager.Factory.create();
        mBtnLoginFacebook = (LoginButton) findViewById(R.id.btn_login_facebook);
        mBtnLoginFacebook.setReadPermissions(Arrays.asList(EMAIL));

        // Callback registration
        mBtnLoginFacebook.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "Login successfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, HomePage.class);
                startActivity(intent);
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    private boolean getListUser(String account, String password) {
        List<User> list = new ArrayList<>();
        list = CoffeeDatabase.getInstance(this).userDao().getListUser(account, password);
//        Toast.makeText(getApplicationContext(), list.get(0).getUserName(), Toast.LENGTH_SHORT).show();

        return list != null && !list.isEmpty();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
