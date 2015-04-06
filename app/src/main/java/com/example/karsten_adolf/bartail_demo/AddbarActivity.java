package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


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

    public void onclickSend(View v) {
        Toast.makeText(getApplicationContext(), "Bar wurde hinzugefügt.", Toast.LENGTH_SHORT ).show();
    }
}
