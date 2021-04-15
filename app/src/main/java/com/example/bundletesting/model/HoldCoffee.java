package com.example.bundletesting.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

//@Entity (tableName = "hold_coffee",
//foreignKeys = @ForeignKey(onDelete = CASCADE, entity = Coffee.class, parentColumns = "id", childColumns ="id"), indices = @Index(value = "id"))
@Entity(tableName = "hold_coffee")
public class HoldCoffee {

//    private int id;

    @PrimaryKey(autoGenerate = true)
    private int idHold;
    @ColumnInfo(name = "nameTable")
    private String nameTable;
    @ColumnInfo(name = "resourceID")
    private int resourceID;
    @ColumnInfo(name = "nameCf")
    private String nameCf;
    @ColumnInfo(name = "priceCf")
    private String priceCf;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    @Ignore
    public HoldCoffee(int resourceID, String nameCf, String priceCf) {
        this.resourceID = resourceID;
        this.nameCf = nameCf;
        this.priceCf = priceCf;
    }

    public HoldCoffee(String nameTable, int resourceID, String nameCf, String priceCf) {
        this.nameTable = nameTable;
        this.resourceID = resourceID;
        this.nameCf = nameCf;
        this.priceCf = priceCf;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getNameCf() {
        return nameCf;
    }

    public void setNameCf(String nameCf) {
        this.nameCf = nameCf;
    }

    public String getPriceCf() {
        return priceCf;
    }

    public void setPriceCf(String priceCf) {
        this.priceCf = priceCf;
    }

    public int getIdHold() {
        return idHold;
    }

    public void setIdHold(int idHold) {
        this.idHold = idHold;
    }
}
