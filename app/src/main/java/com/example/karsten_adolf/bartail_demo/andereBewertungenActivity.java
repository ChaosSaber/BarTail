package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class andereBewertungenActivity extends Activity {

    Bewertung[] bewertungen;
    ListView lv_bewertungen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andere_bewertungen);
        lv_bewertungen=(ListView)findViewById(R.id.lv_bewertungen);
        MyDBHandler dbHandler=new MyDBHandler(this,null,null,1);
        int user_id = ((MyApplication) this.getApplication()).getUser_ID();
        int bar_id = ((MyApplication) this.getApplication()).getBar_ID();
        bewertungen=dbHandler.findOtherBewertung(user_id,bar_id);
        if(bewertungen==null)
        {
            //zeige keine Bewertungen vorhanden
        }
        else
        {
            ListAdapter bar_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, GetStringsFromBewertungen(bewertungen));
            lv_bewertungen.setAdapter(bar_Adapter);
        }
        lv_bewertungen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                zeigeBewertungan(position);
            }
        });
    }

    public void zeigeBewertungan(int position)
    {
        Intent ScreenIntent1 = new Intent(this, BewertungAnzeigenActivity.class);
        ScreenIntent1.putExtra("user_id", bewertungen[position].getUserid());
        ScreenIntent1.putExtra("bar_id", bewertungen[position].getBarid());
        startActivity(ScreenIntent1);
    }


    private String[] GetStringsFromBewertungen(Bewertung[] bewertungen){
        int anzahl=bewertungen.length;
        String[] res=new String[anzahl];
        for(int i=0;i<anzahl;i++)
        {
            String bewertung="";
            for(int j=0;j<bewertungen[i].getRating();j++)
            {
                bewertung+='★';
            }
            bewertung+='\n';
            if(bewertungen[i].getKommentar().length()>40)
            {
                bewertung+=bewertungen[i].getKommentar().substring(0,40);
                bewertung+="...";
            }
            else
                bewertung+=bewertungen[i].getKommentar();
            res[i]=bewertung;
        }
        return res;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_andere_bewertungen, menu);
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

    public void onclickcancel(View v){
        Intent ScreenIntent1 = new Intent(this, BrowseActivity.class);

        startActivity(ScreenIntent1);
    }

    public void onclickMyRating(View v)
    {
        Intent ScreenIntent1 = new Intent(this, BewertenActivity.class);

        startActivity(ScreenIntent1);
    }

    public void onclickOtherRatings(View v)
    {
        //tue nichts
    }
}
