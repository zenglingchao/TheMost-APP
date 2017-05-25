package com.example.ziyulibrary.SqlDB;/*
package com.example.ziyu.mycompro.Utils.com.example.ziyulibrary.SqlDB;

*/
/**
 * Created by 16901 on 2015/12/27.
 *//*


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ziyu.mycompro.Bean.User;

import java.util.ArrayList;
import java.util.List;

//import .OpenHelper;

public class SqliteDB {
    */
/**
     * 数据库名
     *//*

    public static final String DB_NAME = "sqlite_dbname";
    */
/**
     * 数据库版本
     *//*

    public static final int VERSION = 1;

    private static SqliteDB sqliteDB;

    private SQLiteDatabase db;

    private SqliteDB(Context context) {
        OpenHelper dbHelper = new OpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

    */
/**
     * 获取SqliteDB实例
     * @param context
     *//*

    public synchronized static SqliteDB getInstance(Context context) {
        if (sqliteDB == null) {
            sqliteDB = new SqliteDB(context);
        }
        return sqliteDB;
    }

    */
/**
     * 将User实例存储到数据库。
     *//*

    public int  saveUser(User user) {
        if (user != null) {
           */
/* ContentValues values = new ContentValues();
            values.put("username", user.getUsername());
            values.put("userpwd", user.getUserpwd());
            db.insert("User", null, values);*//*


            Cursor cursor = db.rawQuery("select * from User where username=?", new String[]{user.getUsername().toString()});
            if (cursor.getCount() > 0) {
                return -1;
            } else {
                try {
                    db.execSQL("insert into User(username,userpwd) values(?,?) ", new String[]{user.getUsername().toString(), user.getUserpwd().toString()});
                } catch (Exception e) {
                    Log.d("错误", e.getMessage().toString());
                }
                return 1;
            }
        }
        else {
            return 0;
        }
    }

    */
/**
     * 从数据库读取User信息。
     *//*

    public List<User> loadUser() {
        List<User> list = new ArrayList<User>();
        Cursor cursor = db
                .query("User", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex("id")));
                user.setUsername(cursor.getString(cursor
                        .getColumnIndex("username")));
                user.setUserpwd(cursor.getString(cursor

                        .getColumnIndex("userpwd")));
                list.add(user);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public int Quer(String pwd,String name)
    {


        //HashMap<String,String> hashmap=new HashMap<String,String>();
        Cursor cursor =db.rawQuery("select * from User where username=?", new String[]{name});

        // hashmap.put("name",db.rawQuery("select * from User where name=?",new String[]{name}).toString());
        if (cursor.getCount()>0)
        {
            Cursor pwdcursor =db.rawQuery("select * from User where userpwd=? and username=?",new String[]{pwd,name});
            if (pwdcursor.getCount()>0)
            {
                return 1;
            }
            else {
                return -1;
            }
        }
        else {
            return 0;
        }


    }


    */
/**
     * 将Personal实例存储到数据库。
     *//*

    public int  savePersonal(Personal personal) {
        if (personal != null) {
           */
/* ContentValues values = new ContentValues();
            values.put("username", user.getUsername());
            values.put("userpwd", user.getUserpwd());
            db.insert("User", null, values);*//*


            Cursor cursor = db.rawQuery("select * from Personal where username=?", new String[]{personal.getUsername().toString()});
            if (cursor.getCount() > 0) {
                return -1;
            } else {
                try {
                    db.execSQL("insert into Personal(username,sex,age,schoolid,college,email,phone) values(?,?,?,?,?,?,?) ",
                            new String[]{
                                    personal.getUsername().toString(), personal.getSex().toString(),personal.getAge().toString(),
                                    personal.getSchoolid().toString(),personal.getCollege().toString(),personal.getEmail().toString(),
                                    personal.getPhone().toString()
                                           });
                } catch (Exception e) {
                    Log.d("错误", e.getMessage().toString());
                }
                return 1;
            }
        }
        else {
            return 0;
        }
    }

    */
/**
     * 从数据库读取Personal信息。
     *//*

    public List<Personal> loadPersonal() {
        List<Personal> list = new ArrayList<Personal>();
        Cursor cursor = db
                .query("Personal", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Personal Personal = new Personal();
                Personal.setId(cursor.getInt(cursor.getColumnIndex("id")));
                Personal.setUsername(cursor.getString(cursor
                        .getColumnIndex("username")));
                Personal.setSex(cursor.getString(cursor
                        .getColumnIndex("sex")));
                Personal.setAge(cursor.getString(cursor
                        .getColumnIndex("age")));
                Personal.setSchoolid(cursor.getString(cursor
                        .getColumnIndex("schoolid")));
                Personal.setCollege(cursor.getString(cursor
                        .getColumnIndex("college")));
                Personal.setEmail(cursor.getString(cursor
                        .getColumnIndex("email")));
                Personal.setPhone(cursor.getString(cursor
                        .getColumnIndex("phone")));
                list.add(Personal);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public int Quer2(Personal personal) {
        if (personal != null) {
            {
                //HashMap<String> hashmap=new HashMap<String>();
                Cursor cursor = db.rawQuery("select * from Personal where username=?", new String[]{personal.getUsername().toString()});

                //hashmap.put("name",db.rawQuery("select * from User where name=?",new String[]{name}).toString());
                if (cursor.getCount() > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }

        }
        else {
            return -1;
        }
    }


    }


*/
