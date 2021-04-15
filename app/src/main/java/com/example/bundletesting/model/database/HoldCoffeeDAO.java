package com.example.bundletesting.model.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bundletesting.model.Coffee;
import com.example.bundletesting.model.HoldCoffee;

import java.util.List;

@Dao
public interface HoldCoffeeDAO {
    @Insert
    void insertHoldCoffee(HoldCoffee holdCoffee);

    @Query("SELECT * FROM hold_coffee")
    List<HoldCoffee> getListHoldCoffee();

    @Update
    void updateHoldCoffee(HoldCoffee holdCoffee);

    @Delete
    void deleteHoldCoffee(HoldCoffee holdCoffee);

    @Query("DELETE FROM hold_coffee")
    void deleteAllHoldCoffee();

    @Query("DELETE FROM hold_coffee WHERE nameTable = :nameTable")
    void deleteAllHoldCoffeeInTable(String nameTable);

    @Query("SELECT * FROM hold_coffee where nameTable = :nameTable")
    List<HoldCoffee> getListHoldCoffeeAdd(String nameTable);

}
