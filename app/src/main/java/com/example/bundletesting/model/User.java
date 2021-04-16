package com.example.bundletesting.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "userName")
    private String userName;
    @ColumnInfo(name = "account")
    private String account;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "resourceId")
    private int resourceId;
    @ColumnInfo(name = "address")
    private String address;


    public User() {
    }

    @Ignore
    public User(String userName, String account, String password, int resourceId, String address) {
        this.userName = userName;
        this.account = account;
        this.password = password;
        this.resourceId = resourceId;
        this.address = address;
    }

    @Ignore
    public User(String userName, String account, String password, String address) {
        this.userName = userName;
        this.account = account;
        this.password = password;
        this.address = address;
    }

    @Ignore
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String userName, String account, String password) {
        this.userName = userName;
        this.account = account;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
