package com.haze.calculator_gui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "history_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "history";



    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db){

        String text1 = "CREATE TABLE ";
        String text2 = " (ID INTEGER PRIMARY KEY AUTOINCREMENT, ";
        String text3 = " TEXT)";
        String createTable = text1 + TABLE_NAME + text2 + COL2 + text3;
        db.execSQL(createTable);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int it, int i1){

        String drop = "DROP IF TABLE EXISTS";
        db.execSQL(drop  + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);

        Log.d(TAG, "addData: Adding" + item + "to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);


        if(result == -1){
            return false;
        } else {
            return true;
        }
    }





    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }



    public void deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME;

        db.execSQL(query);
       // db.close();
    }


}
