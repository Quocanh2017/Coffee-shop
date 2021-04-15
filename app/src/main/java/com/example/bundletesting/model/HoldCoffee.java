package com.example.bundletesting.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity (tableName = "hold_coffee",
foreignKeys = @ForeignKey(onDelete = CASCADE, entity = Coffee.class, parentColumns = "id", childColumns ="id"), indices = @Index(value = "id"))
public class HoldCoffee {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nameTable;

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    @PrimaryKey(autoGenerate = true)
    private int idHold;

    public HoldCoffee(int id, String nameTable) {
        this.id = id;
        this.nameTable = nameTable;
    }

    public int getIdHold() {
        return idHold;
    }

    public void setIdHold(int idHold) {
        this.idHold = idHold;
    }
}
