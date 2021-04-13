package com.example.bundletesting.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "coffee")
public class Coffee implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int resourceId;
    private String name;
    private String description;
    private String price;

    @Ignore
    public Coffee(String name, String description, String price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Coffee(int resourceId, String name, String description, String price) {
        this.resourceId = resourceId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
