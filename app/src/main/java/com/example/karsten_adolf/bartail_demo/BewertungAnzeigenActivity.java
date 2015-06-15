package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;


public class BewertungAnzeigenActivity extends Activity {

    EditText et_Kommentar;
    RatingBar rb_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bewertung_anzeigen);
        et_Kommentar=(EditText)findViewById(R.id.et_kommentar);
        rb_rating=(RatingBar)findViewById(R.id.rb_rating);
        Intent intent = getIntent();
        // Receiving the Data
        int user_id = intent.getIntExtra("user_id", 0);
        int bar_id = intent.getIntExtra("bar_id", 0);
        MyDBHandler dbHandler=new MyDBHandler(this,null,null,1);
        Bewertung bewertung=dbHandler.findBewertung(user_id,bar_id);
        if(bewertung==null)
        {
            et_Kommentar.setText("Bewertung konte nicht gefunden werden");
            return;
        }
        rb_rating.setNumStars(bewertung.getRating());
        et_Kommentar.setText(bewertung.getKommentar());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bewertung_anzeigen, menu);
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

    public void onclickcancel(View v)
    {
        Intent ScreenIntent1 = new Intent(this, andereBewertungenActivity.class);

        startActivity(ScreenIntent1);
    }
}
