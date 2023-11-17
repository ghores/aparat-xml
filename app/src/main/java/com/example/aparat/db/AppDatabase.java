package com.example.aparat.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aparat.model.Video;

@Database(entities = {Video.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract IDao iDao();

    public static AppDatabase instance = null;

    public synchronized static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "Aparat.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
