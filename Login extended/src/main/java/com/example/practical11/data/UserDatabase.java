package com.example.practical11.data;

import androidx.room.RoomDatabase;
import androidx.room.Database;

import com.example.practical11.models.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
