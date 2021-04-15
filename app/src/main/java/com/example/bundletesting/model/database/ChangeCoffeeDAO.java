package com.example.bundletesting.model.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bundletesting.model.ChangeCoffee;
import com.example.bundletesting.model.Coffee;

import java.util.Collection;
import java.util.List;

@Dao
public interface ChangeCoffeeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChangeCoffee(ChangeCoffee changeCoffee);

    @Query("Select * from changecoffee")
    List<ChangeCoffee> getListChangeCoffee();

    @Query("Select * from ChangeCoffee where name = :name")
    List<ChangeCoffee> checkCoffee(String name);

    @Update
    void updateCoffee(ChangeCoffee changeCoffee);

    @Delete
    void deleteCoffee(ChangeCoffee changeCoffee);
}
