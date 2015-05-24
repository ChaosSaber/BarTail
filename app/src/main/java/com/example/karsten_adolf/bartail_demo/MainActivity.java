package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private Button ButtonLogin, ButtonRegister;
    private static boolean initialisiert=false;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // final TextView textView = (TextView) findViewById(R.id.textView);
        // ButtonLogin = (Button) findViewById(R.id.button);
        // ButtonRegister = (Button) findViewById(R.id.button2);

        init();

    }

    private void init()
    {
        mydb = new DatabaseHelper(this);
        ArrayList array_list = mydb.getAllBars();
       //bef�llt die Bar-Tabelle mit Werten wenn diese leer ist
        MyDBHandler dbHandler=new MyDBHandler(this, null, null, 1);
        if(dbHandler.findBars()!=null)return;
        Bar bar=new Bar(0,"Cocktailbar","Kriegsstra�e 20","76149","Karlsruhe", "19:00","01:00","","eine Cocktailbar","Country");
        dbHandler.AddBar(bar);
        bar=new Bar(0,"Stadtkneipe","Kaiserstra�e 95","76149","Karlsruhe", "20:00","02:00","","eine Stadtkneipe","Jazz");
        dbHandler.AddBar(bar);
        bar=new Bar(0,"Jazzbar","Sudetenstra�e 45","76187","Karlsruhe", "17:00","01:00","","eine Jazzbar","Jazz");
        dbHandler.AddBar(bar);
        bar=new Bar(0,"Studentenbar","Tennesseeallee 8","76149","Karlsruhe", "15:00","20:00","","eine Studentenbar","gemischt");
        dbHandler.AddBar(bar);
        bar=new Bar(0,"Studentenbar an der DH","Erzbergerstra�e 103","76149","Karlsruhe", "08:00","18:00","","noch eine Studentenbar","Country");
        dbHandler.AddBar(bar);
        bar=new Bar(0,"Studentenbar Faulheit","Bierstra�e 3","76149","Karlsruhe", "0:00","24:00","","noch eine Studentenbar, weil ich keine Lust hatte mir etwas anderes asuzudenken","Rock");
        dbHandler.AddBar(bar);
    }

    SuperclassActivity Super = new SuperclassActivity();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onclickLogin(View v) {

        Intent ScreenIntent1 = new Intent(this, LoginActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "MainActivity");
        startActivity(ScreenIntent1);
    }


    public void onclickRegister(View v) {

        Intent ScreenIntent1 = new Intent(this, RegisterActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "MainActivity");
        startActivity(ScreenIntent1);



    }
}
