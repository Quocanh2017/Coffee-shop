package com.example.bundletesting.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bundletesting.model.Coffee;

@Database(entities ={Coffee.class}, version = 1)
public abstract class CoffeeDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "coffee.db";
    private static CoffeeDatabase instance;

    public static synchronized CoffeeDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), CoffeeDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract CoffeeDAO coffeeDAO();
}
