package com.example.karsten_adolf.bartail_demo;


import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result_layout);

        //*************** Kriterien Zusammenfassung ***************///

        Intent activityThatCalled = getIntent();
        TextView ResultText1 = (TextView) findViewById(R.id.result_text1);
        TextView ResultText2 = (TextView) findViewById(R.id.result_text2);
        TextView ResultText3 = (TextView) findViewById(R.id.result_text3);
        TextView ResultText4 = (TextView) findViewById(R.id.result_text4);
        TextView ResultText5 = (TextView) findViewById(R.id.result_text5);

        String PrevActivity = activityThatCalled.getExtras().getString("BarName");
        ResultText1.setText("Barname:   " + String.valueOf(PrevActivity));

        Integer PrevActivity2 = activityThatCalled.getExtras().getInt("BarDistance");
        ResultText2.setText("Entfernung:   " + String.valueOf(PrevActivity2) + " km");

        String PrevActivity3 = activityThatCalled.getExtras().getString("BarPrice");
        ResultText3.setText("Preisspanne:   " + String.valueOf(PrevActivity3));

        String PrevActivity4 = activityThatCalled.getExtras().getString("BarMusic");
        ResultText4.setText("Musik:   " + String.valueOf(PrevActivity4));

        String PrevActivity5 = activityThatCalled.getExtras().getString("BarTime1");
        String PrevActivity6 = activityThatCalled.getExtras().getString("BarTime2");
        ResultText5.setText("Geöffnet:   von "+String.valueOf(PrevActivity5)+" bis "+ String.valueOf(PrevActivity6));

        //*************** Erstellung einer Liste mit Ergebnissen ***************///

        String[] bar_Array = {"1. ALLVITALIS Cocktailbar\n   Stephanienstraße 38-40\n   Karlsruhe",
                "2. ELIO'S Bar\n   Ettlinger Starße 23\n   Karlsruhe", "3. MARESCA'S\n   Hebelstraße 15\n   Karlsruhe",
                "4. PENDEL Bar\n   Blumenstraße 17\n   Karlsruhe",
                "5. SANTO Bar\n   Karlstraße 67-69\n   Karlsruhe", "6. SCHLOSSBAR\n   Bahnhofsplatz 2\n   Karlsruhe"};

        ListAdapter bar_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bar_Array);
        ListView bar_ListView = (ListView) findViewById(R.id.result_list);
        bar_ListView.setAdapter(bar_Adapter);



    }
}
