package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class BewertenActivity extends Activity {

    EditText et_Kommentar;
    TextView ausgabe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bewerten_layout);
        et_Kommentar=(EditText)findViewById(R.id.et_kommentar);
        ausgabe=(TextView)findViewById(R.id.tv_ausgabe);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int user_id = ((MyApplication) this.getApplication()).getUser_ID();
        int bar_id = ((MyApplication) this.getApplication()).getBar_ID();
        Bewertung bewertung=dbHandler.findBewertung(user_id,bar_id);
        if(bewertung!=null)
            et_Kommentar.setText(bewertung.getKommentar());
    }

    SuperclassActivity Super = new SuperclassActivity();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bewerten, menu);
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
        Intent ScreenIntent1 = new Intent(this, BrowseActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }

    public void onclickbewerten(View v)
    {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int user_id = ((MyApplication) this.getApplication()).getUser_ID();
        int bar_id = ((MyApplication) this.getApplication()).getBar_ID();
        Bewertung bewertung=new Bewertung(user_id,bar_id,0,et_Kommentar.getText().toString());
        dbHandler.AddBewertung(bewertung);
        ausgabe.setText("Bewertung abgegeben");
    }
}
