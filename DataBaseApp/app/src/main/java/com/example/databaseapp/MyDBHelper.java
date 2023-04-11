package com.example.databaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Student";
    private static final String TABLE_NAME = "student";
    private static final int DB_VERSION = 1;
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ROLLNO = "rollno";
    private static final String CLASS = "class";
    private static final String GENDER = "gender";
    private static final String ELECTIVE_SUBJECT = "elective_sub";


    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + "TEXT," + ROLLNO + "TEXT,"  +
                CLASS + "TEXT," + GENDER + "TEXT, " + ELECTIVE_SUBJECT + "TEXT)"
                );


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insert(StudentModel studentModel){

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME , studentModel.name);
        contentValues.put(CLASS , studentModel.st_class);
        contentValues.put(ROLLNO , studentModel.rollno);
        contentValues.put(GENDER , studentModel.gender);
        contentValues.put(ELECTIVE_SUBJECT , studentModel.elective_sub);

        db.insert(TABLE_NAME, null, contentValues);
        db.close();


    }
}
