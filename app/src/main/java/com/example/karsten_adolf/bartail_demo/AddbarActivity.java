package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class AddbarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbar_layout);
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

    public void onclickAddbar(View V) {
        Intent ScreenIntent1 = new Intent(this, HomeActivity.class);

        final int result = 1;

        EditText BarNameET = (EditText) findViewById(R.id.et_barname);
        EditText BarStrET = (EditText) findViewById(R.id.et_address);
        EditText BarPLZET = (EditText) findViewById(R.id.et_address2);
        EditText BarStadtET = (EditText) findViewById(R.id.et_address3);
        EditText BarBschrET = (EditText) findViewById(R.id.et_description);
        String BarName = String.valueOf(BarNameET.getText());
        String BarStr = String.valueOf(BarStrET.getText());
        String BarPLZ = String.valueOf(BarPLZET.getText());
        String BarStadt = String.valueOf(BarStadtET.getText());
        String BarBschr = String.valueOf(BarBschrET.getText());

        ScreenIntent1.putExtra("BarName", BarName);
        ScreenIntent1.putExtra("Straße", BarStr);
        ScreenIntent1.putExtra("PLZ", BarPLZ);
        ScreenIntent1.putExtra("Stadt", BarStadt);
        ScreenIntent1.putExtra("Beschreibung", BarBschr);


        
        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);


    }
}
