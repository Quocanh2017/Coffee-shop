package com.example.bundletesting.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bundletesting.model.ChangeTable;

import java.util.List;

@Dao
public interface ChangeTableDAO {
    @Insert
    void insertChangeTable(ChangeTable changeTable);

    @Query("Select * from changetable")
    List<ChangeTable> getListChangeTable();

    @Query("Select * from changetable where name =: name")
    List<ChangeTable> checkTable(String name);

    @Update
    void updateTable(ChangeTable changeTable);
}
