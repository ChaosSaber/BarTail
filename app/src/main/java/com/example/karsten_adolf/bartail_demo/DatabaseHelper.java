package com.example.karsten_adolf.bartail_demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by jonas on 14.05.15.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = ".db";
    private static final int DATABASE_VERSION = 1;
    private static final String BAR_TABLE_NAME = "bars";
    private static final String BAR_COLUMN_ID = "id";
    private static final String BAR_COLUMN_NAME = "name";
    private static final String BAR_COLUMN_STRASSE = "strasse";
    private static final String BAR_COLUMN_HAUSNR = "hausnr";
    private static final String BAR_COLUMN_PLZ = "plz";
    private static final String BAR_COLUMN_STADT = "stadt";

    private HashMap hp;

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        database.execSQL("Bar hinzufügen" + "id integer primary key, name text, strasse text, hausnr integer, plz text, stadt text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        database.execSQL("Drop Table if exists Bar");
        onCreate(database);
    }


    public boolean insertBar  (String name, String strasse, String hausnr, String plz,String stadt)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("strasse", strasse);
        contentValues.put("hausnr", hausnr);
        contentValues.put("plz", plz);
        contentValues.put("stadt", stadt);

        db.insert("bar", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor res =  database.rawQuery( "select * from bars where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase database = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(database, BAR_TABLE_NAME);
        return numRows;
    }


    public boolean updateBars (Integer id, String strasse, String hausnr, String plz,String stadt)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("strasse", strasse);
        contentValues.put("hausnr", hausnr);
        contentValues.put("plz", plz);
        contentValues.put("stadt", stadt);
        database.update("bars", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteBar (Integer id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("bars",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList getAllBars()
    {
        ArrayList array_list = new ArrayList();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from bars", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(BAR_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}



