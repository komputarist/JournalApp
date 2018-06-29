package com.codisats.journalapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface JournalDao {

    @Query("SELECT * FROM entry ORDER BY updated_at")
    LiveData<List<JournalEntry>> loadAllTasks();

    @Insert
    void insertEntry(JournalEntry journalEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateEntry(JournalEntry taskEntry);

    @Delete
    void deleteEntry(JournalEntry taskEntry);

    @Query("SELECT * FROM entry WHERE id = :id")
    LiveData<JournalEntry> loadEntryById(int id);
}
