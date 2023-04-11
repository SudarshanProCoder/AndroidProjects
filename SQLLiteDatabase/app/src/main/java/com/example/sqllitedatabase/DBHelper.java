package com.example.sqllitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table userdetails(name TEXT primary key, branch TEXT, roll_no TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists userdetails");

    }

    public Boolean insertData(String name, String branch, String roll_no){
        SQLiteDatabase DB =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("branch", branch);
        contentValues.put("roll_no", roll_no);
        long result = DB.insert("userdetails", null, contentValues);

        if(result == -1 && name == "" && branch == "" && roll_no == ""){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateData(String name, String branch, String roll_no){
        SQLiteDatabase DB =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("branch", branch);
        contentValues.put("roll_no", roll_no);
        Cursor cursor = DB.rawQuery("select * from userdetails where name = ?", new String[] {name});
        if(cursor.getCount() > 0) {


            long result = DB.update("userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }
    public Boolean deleteData(String name){
        SQLiteDatabase DB =  this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from userdetails where name = ?", new String[] {name});
        if(cursor.getCount() > 0) {


            long result = DB.delete("userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }
    public Cursor getData(){
        SQLiteDatabase DB =  this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from userdetails", null);
        return cursor;
    }
}
