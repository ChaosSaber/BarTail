package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    private Button ButtonLogin, ButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // final TextView textView = (TextView) findViewById(R.id.textView);
       // ButtonLogin = (Button) findViewById(R.id.button);
       // ButtonRegister = (Button) findViewById(R.id.button2);


        };



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
