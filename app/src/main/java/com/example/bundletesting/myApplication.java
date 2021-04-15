package com.example.bundletesting;

import android.app.Application;

public class myApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //sharePre was init
        DataLocalTransfer.initDataLocalTransfer(getApplicationContext());
    }
}
