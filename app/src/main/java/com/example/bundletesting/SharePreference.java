package com.example.bundletesting;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreference {
    private static final String SHARE_PREFERENCES = "SHARE";
    private static final String A_SHARE_REFERENCE = "SUCCESS";
    private Context context;

    public SharePreference(Context context) {
        this.context = context;
    }
    public void putStringCategory(String key, String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String getStringCategory(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }
    // internet
    public void putIntInternetState(String key,int value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(A_SHARE_REFERENCE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key,value);
        editor.apply();
    }
    public int getIntInternetState(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(A_SHARE_REFERENCE,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key,0);
    }
}
