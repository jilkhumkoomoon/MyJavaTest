package com.mycode.myjavatest.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1,exportSchema = false)
public abstract class WordDatabase  extends RoomDatabase {
    public abstract WordDao getWordDao();
}
