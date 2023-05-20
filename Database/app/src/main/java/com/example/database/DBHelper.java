package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {



    DBHelper(Context context){
        super(context, "customerDB", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table customersData(_id integer primary key autoincrement, name TEXT, address TEXT, mobileNo TEXT, pincode TEXT)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists customersData");
        onCreate(sqLiteDatabase);
    }

    public Boolean insertData(String name, String address, String MobileNo, String Pincode){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("Name", name);
        cv.put("address", address);
        cv.put("mobileNo", MobileNo);
        cv.put("pincode", Pincode);

        long r = db.insert("customersData", null, cv);
        if(r == -1) return false;
        else return true;


    }

    public Cursor get_data(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from customersData", null);
        return cursor;

    }

    public Boolean delete_data(String name){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from customersData where name = ?", new String[]{name});

        if(cursor.getCount() > 0){
            long r = db.delete("customersData", "name=?", new String[]{name});
            if (r == -1) return false;
            else return true;

        }else
            return false;

    }
    public Boolean update_data(String Name, String Address, String MobileNo, String Pincode){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Name", Name);
        cv.put("address", Address);
        cv.put("mobileNo", MobileNo);
        cv.put("pincode", Pincode);
        Cursor cursor = db.rawQuery("select * from customersData where name = ?", new String[]{Name});

        if(cursor.getCount() > 0){
            long r = db.update("customersData", cv,"name=?", new String[]{Name});
            if (r == -1) return false;
            else return true;

        }else
            return false;

    }
}
