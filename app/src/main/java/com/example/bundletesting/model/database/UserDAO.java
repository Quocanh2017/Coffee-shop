package com.example.bundletesting.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bundletesting.model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);

    @Query("select * from user where userName=:userName and password=:password")
    List<User> getListUser(String userName, String password);
}
