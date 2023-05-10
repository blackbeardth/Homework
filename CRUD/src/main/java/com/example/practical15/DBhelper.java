package com.example.practical15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper( Context context) {

        super(context, "userDB5.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table appform(_sid integer primary key autoincrement," +
                " name TEXT, age TEXT, mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists appform");
    }
    public Boolean insertuserdata(String name, String age, String mobile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("mobile", mobile);
        long result = db.insert("appform", null, contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Boolean updateuserdata(String name, String age, String mobile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("age", age);
        contentValues.put("mobile", mobile);
        Cursor cursor = db.rawQuery("Select * from appform where name = ?",
                new String[]{name});
        if (cursor.getCount() > 0) {
            long result = db.update("appform", contentValues, "name = ?",
                    new String[] {name});
            if (result == -1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }
    public Boolean deletedata(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from appform where name = ?",
                new String[] {name});
        if (cursor.getCount() > 0)
        {
            long result = db.delete("appform", "name=?", new String[]{name});
            if (result == -1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }
    public Cursor getdata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from appform",null);
        return cursor;
    }
}
