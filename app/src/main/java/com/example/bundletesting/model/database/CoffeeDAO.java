package com.example.bundletesting.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bundletesting.model.Coffee;

import java.util.List;

@Dao
public interface CoffeeDAO {

    @Insert
    void insertCoffee(Coffee coffee);

    @Query("Select * from coffee")
    List<Coffee> getListCoffee();

    @Query("SELECT * FROM coffee where id = :id")
    List<Coffee> getListCoffeeID(int id);
}
