package com.example.bundletesting;

import android.content.Context;

import com.example.bundletesting.model.Coffee;
import com.google.gson.Gson;

public class DataLocalTransfer {
    private static final String KEY_COFFEE = "KEY_COFFEE";
    private static final String ID_INTERNET_STATE = "ID_INTERNET_STATE";
    private static DataLocalTransfer instance;
    private SharePreference sharePreference;

    public static void initDataLocalTransfer(Context context) {
        instance = new DataLocalTransfer();
        instance.sharePreference = new SharePreference(context);
    }
    public static DataLocalTransfer getInstance(){
        if(instance == null){
            instance = new DataLocalTransfer();
        }
        return instance;
    }
    public static void setInternetState(int state){
        DataLocalTransfer.getInstance().sharePreference.putIntInternetState(ID_INTERNET_STATE,state);
    }
    public static int getInternetState(){
        return DataLocalTransfer.getInstance().sharePreference.getIntInternetState(ID_INTERNET_STATE);
    }
}
