package com.example.karsten_adolf.bartail_demo.DBFiles;


import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by jonas on 26.05.15.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil{

    public static final Class<?>[] classes = new Class[]{Bar.class, User.class};

    public static void main(String[] args) throws IOException, SQLException {

        //TODO: Hier den eigenen Class-Path einfügen, wenn die ormlite_config.txt aktualisiert werden muss!
        File rawFolder = new File("/Users/jonas/Documents/GitHub/BarTail/app/src/main/res/raw", "ormlite_config.txt");

        //Erstellen der ormlite_config.txt für die Verwaltung der Datenbank-Modelle
        writeConfigFile(rawFolder, classes);

    }
}
