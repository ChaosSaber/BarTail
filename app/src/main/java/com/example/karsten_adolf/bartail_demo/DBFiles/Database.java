package com.example.karsten_adolf.bartail_demo.DBFiles;



import android.util.Log;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;


/**
 * Created by jonas on 26.05.15.
 */
public class Database {

    private static final String TAG = "Database";

    public static ConnectionSource makeConnection(){

        final String DATABASE_USERNAME = "User";
        final String DATABASE_PASSWORD = "Passwort";
        final String DATABASE_URL = "jdbc:mysql://....";
        final String driver = "com.mysql.jdbc.Driver";

        ConnectionSource connectionSource = null;

        try {
            Class.forName(driver);
            connectionSource = new JdbcConnectionSource(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "makeConnection() failed to connect to Databse: " + e.getMessage());
        }

        return connectionSource;
    }
}
