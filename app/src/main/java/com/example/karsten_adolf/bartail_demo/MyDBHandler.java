package com.example.karsten_adolf.bartail_demo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by René on 08.05.2015.
 */
public class MyDBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BarTail.db";
    private static final String TABLE_USER = "users";
    private static final String TABLE_Bar = "Bars";

    //Spalten von Users
    public static final String COLUMN_ID = "User_id";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_E_MAIL = "E_Mail";
    public static final String COLUMN_PASSWORT = "Passwort";

    //Spalten von Bars
    public static final String Column_BID = "Bar_ID";
    public static final String Column_BNAME = "BarName";
    public static final String Column_BADRESSE = "BarAdresse";
    public static final String Column_BPLZ = "PLZ";
    public static final String Column_BORT = "ORT";
    public static final String Column_BBESCHREIBUNG = "Beschreibung";
    public static final String Column_BLINK = "Link";
    public static final String Column_BOEFFNUNG = "Oeffnungszeit";
    public static final String Column_BSCHLIESSUNG = "Schliessungszeit";
    public static final String Column_BMUSIKRICHTUNG = "Musikrichtung";

    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_USER + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_USERNAME
                + " TEXT," + COLUMN_E_MAIL + " TEXT," + COLUMN_PASSWORT + " TEXT"+ ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
        CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_Bar + "(" + Column_BID
                + " INTEGER PRIMARY KEY," + Column_BNAME + " TEXT," + Column_BADRESSE
                + " TEXT," + Column_BPLZ + " TEXT," + Column_BORT + " TEXT,"
                + Column_BBESCHREIBUNG + " TEXT," + Column_BLINK + " TEXT,"
                + Column_BOEFFNUNG + " TEXT," + Column_BSCHLIESSUNG + " TEXT,"
                + Column_BMUSIKRICHTUNG + " TEXT)";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Bar);
        onCreate(db);
    }

    public void AddUser(User nutzer)
    {
        ContentValues values = new ContentValues();

        values.put(COLUMN_USERNAME,nutzer.getUsername());
        values.put(COLUMN_E_MAIL,nutzer.getE_mail());
        values.put(COLUMN_PASSWORT, nutzer.getPasswort());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public  User findUser(String e_mail)
    {
        String query = "Select * FROM " + TABLE_USER + " WHERE " + COLUMN_E_MAIL + " =  \"" + e_mail + "\"";

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        User user=new User();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            user.setUser_ID(Integer.parseInt(cursor.getString(0)));
            user.setUsername(cursor.getString(1));
            user.setE_mail(cursor.getString(2));
            user.setPasswort(cursor.getString(3));
            cursor.close();
        } else {
            user = null;
        }
        db.close();
        return user;
    }

    public Bar[] findBars()
    {
        String query = "Select * FROM " + TABLE_Bar;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return getBars(cursor);
    }

    private Bar[] getBars(Cursor cursor)
    {
        if(cursor==null)
            return null;
        int ergebnisanzahl=cursor.getCount();
        if(ergebnisanzahl==0)
            return null;

        Bar[] Bars=new Bar[ergebnisanzahl];
        cursor.moveToFirst();

        for(int i=0; i<ergebnisanzahl;i++)
        {
            Bars[i].setID(cursor.getInt(0));
            Bars[i].setName(cursor.getString(1));
            Bars[i].setAdresse(cursor.getString(2));
            Bars[i].setPLZ(cursor.getString(3));
            Bars[i].setOrt(cursor.getString(4));
            Bars[i].setBeschreibung(cursor.getString(5));
            Bars[i].setLink(cursor.getString(6));
            Bars[i].setOeffnungszeiten(cursor.getString(7));
            Bars[i].setSchliessungszeiten(cursor.getString(8));
            Bars[i].setMusikrichtung(cursor.getString(9));
            cursor.moveToNext();
        }

        return  Bars;
    }



}