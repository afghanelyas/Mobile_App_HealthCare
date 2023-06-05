package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {


    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Qry1 = "create table users(username text , email text , password text)";
        db.execSQL(Qry1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void register(String username , String email , String password){
        ContentValues cv = new ContentValues();
        cv.put("username" , username);
        cv.put("email" , email);
        cv.put("password" , password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null , cv);
        db.close();
    }

}
