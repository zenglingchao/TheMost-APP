package com.example.ziyu.themostdemo.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziyu on 2016/9/28  13:00.
 */

public class DataBaseUtil {

    private DataBase database;
    private SQLiteDatabase sqLiteDatabase;

    public  DataBaseUtil getInstance(Context context) {
        database = new DataBase(context);
        sqLiteDatabase = database.getReadableDatabase();
        return this;
    }

    public void close() {
        if (database != null) {
            database.close();
            sqLiteDatabase.close();
        }
    }

    //将MagazineID存入数据库
    public DataBaseUtil saveMagazine(int id) {

        ContentValues values = new ContentValues();
        values.put("magazineId", id);
        sqLiteDatabase.insert("magazine", null, values);

        return this;
    }
    public DataBaseUtil saveProduct(int id) {

        ContentValues values = new ContentValues();
        values.put("productId", id);
        sqLiteDatabase.insert("product", null, values);

        return this;
    }
    public DataBaseUtil saveDesigner(int id) {

        ContentValues values = new ContentValues();
        values.put("designerId", id);
        sqLiteDatabase.insert("designer", null, values);

        return this;
    }
    //查询单个是否存在
    public boolean isExist(int id ,String table,String rankName){
       String querysql = "select * from " + table + " where " + rankName + " = " + id;
		Cursor cursor = sqLiteDatabase.rawQuery(querysql, null);
        //Cursor cursor = sqLiteDatabase.query(table, new String[]{rankName}, null, new String[]{id +""}, null, null, null);
        if (cursor.getCount() > 0) {
            close(); //关闭数据库
            return true;
        }
        close();
        return false;
    }

    //查询全部
    public List<Integer> getMagazineList() {
        List<Integer> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("magazine", new String[]{"magazineId"}, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int magazineId = cursor.getInt(cursor.getColumnIndex("magazineId"));
                list.add(magazineId);
            }
        }
        close(); //关闭数据库
        return list;
    }
    public List<Integer> getDesignerList() {
        List<Integer> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("designer", new String[]{"designerId"}, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int magazineId = cursor.getInt(cursor.getColumnIndex("designerId"));
                list.add(magazineId);
            }
        }
        close(); //关闭数据库
        return list;
    }
    public List<Integer> getProductList() {
        List<Integer> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("product", new String[]{"productId"}, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int magazineId = cursor.getInt(cursor.getColumnIndex("productId"));
                list.add(magazineId);
            }
        }
        close(); //关闭数据库
        return list;
    }

    //删除
    public void removeMagazine(int id){
        String deletesql = "delete from magazine where magazineId= ?";
		sqLiteDatabase.execSQL(deletesql, new Object[]{id});
    }
    public void removeProduct(int id){
        String deletesql = "delete from product where productId= ?";
        sqLiteDatabase.execSQL(deletesql, new Object[]{id});
    }
    public void removeDesigner(int id){
        String deletesql = "delete from designer where DesignerId= ?";
        sqLiteDatabase.execSQL(deletesql, new Object[]{id});
    }
}
