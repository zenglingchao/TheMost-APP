package com.example.ziyu.themostdemo.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ziyu on 2016/11/13.
 */

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {
        super(context, "myDateBase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table magazine ( _id integer primary key , magazineId)");
        db.execSQL("create table product ( _id integer primary key , productId)");
        db.execSQL("create table designer ( _id integer primary key , designerId)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
