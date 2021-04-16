package com.example.bundletesting.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "table")
public class Table {
//    @PrimaryKey(autoGenerate = true)
    private int id;

    private int resourceImage;
    private String numberTable;

    public Table(String numberTable) {
        this.numberTable = numberTable;
    }

    public Table(int resourceImage, String numberTable) {
        this.resourceImage = resourceImage;
        this.numberTable = numberTable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getNumberTable() {
        return numberTable;
    }

    public void setNumberTable(String numberTable) {
        this.numberTable = numberTable;
    }
}
