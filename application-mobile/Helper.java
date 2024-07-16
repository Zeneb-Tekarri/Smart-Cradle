package com.example.bebe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    public Helper(@Nullable Context context) {
        super(context,"calender",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase dbase) {
        dbase.execSQL("CREATE TABLE events( _id INTEGER PRIMARY KEY,title TEXT,date REAL,description TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase dbase, int i, int i1) {
        dbase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(dbase);

    }
    public void insertEvent(events e){
        SQLiteDatabase dbase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title",e.getTitle());
        cv.put("date",e.getDate());
        cv.put("description", e.getDescription());
        dbase.insert("events",null,cv);
        dbase.close();
    }
    public void updateEvent(events e){
        SQLiteDatabase dbase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title",e.getTitle());
        cv.put("date",e.getDate());
        cv.put("description", e.getDescription());
        dbase.update("events",cv,"_id=?",new String[]{String.valueOf(e.get_id())});
        dbase.close();
    }
    public void deleteEvent(int id){
        SQLiteDatabase dbase = this.getWritableDatabase();
        dbase.delete("events","_id=?",new String[]{String.valueOf(id)});
        dbase.close();
    }
    public Cursor getAllEvent(){
        SQLiteDatabase dbase = this.getReadableDatabase();
        Cursor c = dbase.rawQuery("SELECT * FROM events",null);
        return c;
    }
    public events getOneEvent(int id){
        SQLiteDatabase dbase = this.getReadableDatabase();
        Cursor c = dbase.query("events",new String[]{"_id","title","date","description"},"_id=?",
                new String[]{String.valueOf(id)},null,null,null);
        c.moveToFirst();
        events e = new events(c.getInt(0),c.getString(1),c.getDouble(2),c.getString(3));
        return  e;
    }
}