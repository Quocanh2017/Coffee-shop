package com.example.bundletesting.model.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bundletesting.model.ChangeTable;
import com.example.bundletesting.model.Table;

import java.util.Collection;
import java.util.List;

@Dao
public interface ChangeTableDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChangeTable(ChangeTable changeTable);

    @Query("Select * from changetable")
    List<ChangeTable> getListChangeTable();

    @Query("Select * from changetable where name = :name")
    List<ChangeTable> checkTable(String name);

    @Update
    void updateTable(ChangeTable changeTable);

    @Delete
    void deleteTable(ChangeTable changeTable);
}
