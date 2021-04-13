package com.example.bundletesting;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefers {

    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("coffeeApp", Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }
}
