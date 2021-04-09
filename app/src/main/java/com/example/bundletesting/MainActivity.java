package com.example.bundletesting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.bundletesting.view.HomePage;
import com.example.bundletesting.view.Login;
import com.example.bundletesting.view.SignUp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button bt, bt1, bt2;

    boolean connected;

    private static final String DEBUG_TAG = "NetWork Status Connected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
//                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
//            //we are connected to a network
//            connected = true;
//
//        }
//        else
//            connected = false;

        // Connected to network

        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isWifiConn = false;
        boolean isMobileConn = false;
        for (Network network : connMgr.getAllNetworks()) {
            NetworkInfo networkInfo = connMgr.getNetworkInfo(network);
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                isWifiConn |= networkInfo.isConnected();
                System.out.println("hello");
            }
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                isMobileConn |= networkInfo.isConnected();
                System.out.println("hi");

            }
        }
        Log.d(DEBUG_TAG, "Wifi connected: " + isWifiConn);
        Log.d(DEBUG_TAG, "Mobile connected: " + isMobileConn);

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