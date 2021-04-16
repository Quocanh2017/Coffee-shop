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

    @Query("select * from user where account=:account and password=:password")
    List<User> getListUser(String account, String password);

    @Query("select * from user")
    List<User> getListUser();

    @Query("UPDATE user SET USERNAME = :userName, account = :account, password = :password, address = :address where username = :userName and password = :password")
    void setListUser(String userName, String account, String password, String address);
}
