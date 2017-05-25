package com.example.ziyulibrary.SqlDB;/*
package com.example.ziyu.mycompro.Utils.com.example.ziyulibrary.SqlDB;

*/
/**
 * Created by 16901 on 2015/12/27.
 *//*


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper {

    //建表语句
    public static final String CREATE_USER = "create table User ("
            + "id integer primary key autoincrement, "
            + "username text, "
            + "userpwd text)";

    public static final String CREATE_PERSONAL = "create table Personal ("
            + "id integer primary key autoincrement, "
            + "username text, "
            + "age text"
            +"schoolid text"
            +"email text"
            +"phone text"
            +"colloge text)";


    public OpenHelper(Context context, String name, CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL(CREATE_USER);//创建用户表
        db.execSQL(CREATE_PERSONAL);//创建用户信息表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
*/
