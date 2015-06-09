package com.example.karsten_adolf.bartail_demo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ren� on 08.05.2015.
 */
public class MyDBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BarTail.db";
    private static final String TABLE_USER = "users";
    private static final String TABLE_Bar = "Bars";
    private static final String TABLE_addbar = "neue_bar";
    private static final String TABLE_bewertung = "Bewertung";

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

    //spalten von Bewertung
    public static final String Column_User_ID = "User_id";
    public static final String Column_Bar_ID = "Bar_id";
    public static final String Column_Rating = "Rating";
    public static final String Column_Kommentar = "Kommentar";

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
        CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_addbar + "(" + Column_BID
                + " INTEGER PRIMARY KEY," + Column_BNAME + " TEXT," + Column_BADRESSE
                + " TEXT," + Column_BPLZ + " TEXT," + Column_BORT + " TEXT,"
                + Column_BBESCHREIBUNG + " TEXT," + Column_BLINK + " TEXT,"
                + Column_BOEFFNUNG + " TEXT," + Column_BSCHLIESSUNG + " TEXT,"
                + Column_BMUSIKRICHTUNG + " TEXT)";
        db.execSQL(CREATE_PRODUCTS_TABLE);
        CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_bewertung + "(" + Column_User_ID
                + " INTEGER," + Column_Bar_ID + " INTEGER," + Column_Rating
                + " INTEGER," + Column_Kommentar + " TEXT)";
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

    public void AddBar(Bar bar)
    {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();

        CreateArray(values, bar);

        db.insert(TABLE_Bar, null, values);
        db.close();
    }

    private void CreateArray(ContentValues values, Bar bar){

        values.put(Column_BNAME,bar.getName());
        values.put(Column_BADRESSE,bar.getAdresse());
        values.put(Column_BORT,bar.getOrt());
        values.put(Column_BPLZ,bar.getPLZ());
        values.put(Column_BBESCHREIBUNG,bar.getBeschreibung());
        values.put(Column_BOEFFNUNG,bar.getOeffnungszeiten());
        values.put(Column_BSCHLIESSUNG,bar.getSchliessungszeiten());
        values.put(Column_BMUSIKRICHTUNG,bar.getMusikrichtung());
        values.put(Column_BLINK,bar.getLink());

    }

    public Bar[] findBars()
    {
        String query = "Select * FROM " + TABLE_Bar;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Bar[] Bars= getBars(cursor);
        db.close();
        return Bars;
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
            Bar bar=new Bar();
            bar.setID(cursor.getInt(0));
            bar.setName(cursor.getString(1));
            bar.setAdresse(cursor.getString(2));
            bar.setPLZ(cursor.getString(3));
            bar.setOrt(cursor.getString(4));
            bar.setBeschreibung(cursor.getString(5));
            bar.setLink(cursor.getString(6));
            bar.setOeffnungszeiten(cursor.getString(7));
            bar.setSchliessungszeiten(cursor.getString(8));
            bar.setMusikrichtung(cursor.getString(9));
            Bars[i]=bar;
            cursor.moveToNext();
        }

        return  Bars;
    }

    public void AddNewBar(Bar bar)
    {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();

        CreateArray(values, bar);

        db.insert(TABLE_addbar, null, values);
        db.close();
    }

    public Bewertung findBewertung(int user_id, int bar_id)
    {
        Bewertung bewertung=new Bewertung();

        String query = "Select * FROM " + TABLE_bewertung + " WHERE " + Column_User_ID + "="
                + user_id + " AND " + Column_Bar_ID + "=" + bar_id;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int test = cursor.getCount();
        test=cursor.getCount();

        if(cursor.moveToFirst())
        {
            bewertung.setBarid(bar_id);
            bewertung.setUserid(user_id);
            bewertung.setKommentar(cursor.getString(3));
        }
        else return null;

        db.close();
        return bewertung;
    }

    public void AddBewertung(Bewertung bewertung)
    {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();

        values.put(Column_User_ID,bewertung.getUserid());
        values.put(Column_Bar_ID,bewertung.getBarid());
        values.put(Column_Rating,bewertung.getRating());
        values.put(Column_Kommentar,bewertung.getKommentar());

        db.insert(TABLE_bewertung, null, values);
        db.close();
    }


    public  void dropBars()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE Bars");
    }

    public void createBars()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_Bar + "(" + Column_BID
                + " INTEGER PRIMARY KEY," + Column_BNAME + " TEXT," + Column_BADRESSE
                + " TEXT," + Column_BPLZ + " TEXT," + Column_BORT + " TEXT,"
                + Column_BBESCHREIBUNG + " TEXT," + Column_BLINK + " TEXT,"
                + Column_BOEFFNUNG + " TEXT," + Column_BSCHLIESSUNG + " TEXT,"
                + Column_BMUSIKRICHTUNG + " TEXT)";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

}