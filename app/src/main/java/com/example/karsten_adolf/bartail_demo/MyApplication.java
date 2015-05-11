package com.example.karsten_adolf.bartail_demo;

import android.app.Application;

/**
 * Created by René on 11.05.2015.
 */

//globale Variablen
// so nutzen
// set
        //((MyApplication) this.getApplication()).setUser_ID(3);
// get
        //int id = ((MyApplication) this.getApplication()).getUser_ID();
//Implementierung in AndroidManifest.xml
//<application android:name="MyApplication">
public class MyApplication extends Application {

    private int User_ID;
    private int Bar_ID;

    public int getBar_ID() {
        return Bar_ID;
    }

    public void setBar_ID(int bar_ID) {
        Bar_ID = bar_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }
}
