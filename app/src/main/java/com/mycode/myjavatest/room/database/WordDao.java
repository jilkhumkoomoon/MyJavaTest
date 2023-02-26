package com.mycode.myjavatest.room.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insertWords(Word... words);

    @Update
    void updateWord(Word... words);

    @Delete
    void deleWord(Word... words);

    @Query("DELETE FROM WORD")
    void deleteAllWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    LiveData<List<Word>> getAllWords();
}
