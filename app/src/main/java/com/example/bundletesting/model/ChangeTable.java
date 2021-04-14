package com.example.bundletesting.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "changetable")
public class ChangeTable implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int sourceID;
    @ColumnInfo(name = "name")
    private String name;

    @Ignore
    public ChangeTable(int sourceID, String name) {
        this.sourceID = sourceID;
        this.name = name;
    }

    public ChangeTable( String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSourceID() {
        return sourceID;
    }

    public void setSourceID(int sourceID) {
        this.sourceID = sourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
