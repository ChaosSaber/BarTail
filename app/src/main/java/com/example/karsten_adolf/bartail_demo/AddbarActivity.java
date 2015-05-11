package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class AddbarActivity extends Activity {
    EditText et_name,et_adresse,et_plz,et_ort,et_beschreibung;
    TextView ausgabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbar_layout);
        et_name=(EditText)findViewById(R.id.et_barname);
        et_adresse=(EditText)findViewById(R.id.et_address);
        et_plz=(EditText)findViewById(R.id.et_address2);
        et_ort=(EditText)findViewById(R.id.et_address3);
        et_beschreibung=(EditText)findViewById(R.id.et_description);
        ausgabe=(TextView)findViewById(R.id.tv_ausgabe);
    }

    public void onclickBrowse(View v) {
        Intent ScreenIntent1 = new Intent(this, BrowseActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }

    public void onclickSearch(View v) {
        Intent ScreenIntent1 = new Intent(this, SearchActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }

    public void onclickBack(View v) {
        Intent ScreenIntent1 = new Intent(this, HomeActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }

    public void onClickaddbar(View v)
    {
        Bar bar=new Bar();

        bar.setName(et_name.getText().toString());
        bar.setAdresse(et_adresse.getText().toString());
        bar.setPLZ(et_plz.getText().toString());
        bar.setOrt(et_ort.getText().toString());
        bar.setBeschreibung(et_beschreibung.getText().toString());

        MyDBHandler dbHandler=new MyDBHandler(this, null, null, 1);
        dbHandler.AddNewBar(bar);
        ausgabe.setText("Bar hinzugefuegt");
    }
}
