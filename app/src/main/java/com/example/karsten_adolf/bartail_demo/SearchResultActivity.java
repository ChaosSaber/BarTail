package com.example.karsten_adolf.bartail_demo;


import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.DOMStringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchResultActivity extends Activity{

    //Erstellen von einer Stringliste für Bartour Elemente
    final ArrayList<String> barlistGesamt = new ArrayList<>();


    MyDBHandler db = new MyDBHandler(this,null,null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result_layout);

        //*************** Kriterien Zusammenfassung ***************///

        //BartourArray wird initalisiert

        Intent activityThatCalled = getIntent();
        TextView ResultText1 = (TextView) findViewById(R.id.tv_summary_name);
        TextView ResultText2 = (TextView) findViewById(R.id.tv_summary_distance);
        TextView ResultText3 = (TextView) findViewById(R.id.tv_summary_price);
        TextView ResultText4 = (TextView) findViewById(R.id.tv_summary_music);
        TextView ResultText5 = (TextView) findViewById(R.id.tv_summary_open);

        String ResultBarname = activityThatCalled.getExtras().getString("BarName");
        ResultText1.setText("Barname:   " + String.valueOf(ResultBarname));

        Integer ResultEntfernung = activityThatCalled.getExtras().getInt("BarDistance");
        ResultText2.setText("Entfernung:   " + String.valueOf(ResultEntfernung) + " km");

        String ResultPreis = activityThatCalled.getExtras().getString("BarPrice");
        ResultText3.setText("Preisspanne:   " + String.valueOf(ResultPreis));

        String ResultMusik = activityThatCalled.getExtras().getString("BarMusic");
        ResultText4.setText("Musik:   " + String.valueOf(ResultMusik));

        String ResultZeit1 = activityThatCalled.getExtras().getString("BarTime1");
        String ResultZeit2 = activityThatCalled.getExtras().getString("BarTime2");
        ResultText5.setText("Geöffnet:   von "+String.valueOf(ResultZeit1)+" bis "+ String.valueOf(ResultZeit2));


        //*************** Erstellung einer Liste mit Ergebnissen ***************///

        
        Bar[] DB_Barliste = db.findBars();
        Bar[] BarlisteName = db.findBarByName(ResultBarname);
        Bar[] BarlisteMusic = db.findBarByMusikrichtung(ResultMusik);

        ArrayList<String> barlst = new ArrayList<>();
        String ListItem;
        boolean isInList = true;

        if(BarlisteName == null && BarlisteMusic == null) Toast.makeText(getBaseContext(), "Keine Bars entsprechen\nihren Suchkriterien.", Toast.LENGTH_SHORT).show();

        try {
            if ((BarlisteName.length > 5) && (BarlisteMusic.length < 6)) {
            //Nichts tun
            }

            else if (BarlisteName != null) {
                for (int k = 0; k < BarlisteName.length; k++) {
                    barlst.add(BarlisteName[k].getName() + "\n " + BarlisteName[k].getAdresse() + "\n " + BarlisteName[k].getOrt() + "\n " + BarlisteName[k].getMusikrichtung());
                }
            }
            ;
        }
        catch (Exception ex) {Toast.makeText(getBaseContext(), "Keine Bars entsprechen\nihren Suchkriterien.", Toast.LENGTH_SHORT).show();}

        if (BarlisteMusic != null) {
                for (int k = 0; k < BarlisteMusic.length; k++) {

                    isInList = false;
                    ListItem = (BarlisteMusic[k].getName() + "\n " + BarlisteMusic[k].getAdresse() + "\n " + BarlisteMusic[k].getOrt() + "\n " + BarlisteMusic[k].getMusikrichtung());

                    for (int i = 0; i < barlst.size(); i++) {
                        if (barlst.get(i).equals(ListItem)) isInList = true;
                    }

                    if (isInList == false) barlst.add(ListItem);

                }
        }





        int k;
        for(k = 0; k < DB_Barliste.length; k++)
        {

            //barlst.add(DB_Barliste[k].getName() + "\n " + DB_Barliste[k].getAdresse() + "\n " + DB_Barliste[k].getOrt()+ "\n " + DB_Barliste[k].getMusikrichtung());
        }

        ListAdapter bar_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, barlst);
        ListView bar_ListView = (ListView) findViewById(R.id.result_list);
        bar_ListView.setAdapter(bar_Adapter);
        
        bar_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = ((TextView) view).getText().toString();
                int i,k = 0 ;

                for (i= 0; i< item.length(); i++){
                    if (item.charAt(i) == '\n')
                    {
                        k = i;
                        i = item.length();
                    }
                }

                item = item.substring(0, k);


                if (barlistGesamt.isEmpty()){
                    barlistGesamt.add(item);
                    item += " wurde zur Tour hinzugefügt.";
                    Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
                }

                else {
                    for (i = 0; i < barlistGesamt.size(); i++){
                        if (barlistGesamt.get(i).equals(item)) {
                            Toast.makeText(getBaseContext(), "Wurde bereits hinzugefügt.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    barlistGesamt.add(item);
                    item += " wurde zur Tour hinzugefügt.";
                    Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }



    public void onclickBartour(View v) {
        Intent ScreenIntent1 = new Intent(this, BarTourActivity.class);

        ScreenIntent1.putExtra("BarTourArray", barlistGesamt);

        startActivity(ScreenIntent1);

    }



}
