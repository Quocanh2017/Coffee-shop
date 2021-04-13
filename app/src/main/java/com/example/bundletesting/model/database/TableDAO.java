package com.example.bundletesting.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bundletesting.model.Table;

import java.util.List;

@Dao
public interface TableDAO {
    @Insert
    void insertTable(Table table);

    @Query("select * from `table`")
    List<Table> getListTable();
}
