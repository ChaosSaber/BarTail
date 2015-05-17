package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Leon on 04.05.2015.
 */
// Realisierung der Patterns
public class SuperclassActivity extends Activity {

    private Button ButtonLogin, ButtonLoginAd, ButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_layout);

    };

    //Button-Funktionen auf die extern zugegriffen werden

    public void onclickLoginOpen(View v) {

        Intent ScreenIntent1 = new Intent(this, LoginActivity.class);

        startActivity(ScreenIntent1);
    }

    public void onclickRegisterOpen(View v) {

        Intent ScreenIntent1 = new Intent(this, RegisterActivity.class);

        startActivity(ScreenIntent1);
    }

    public void onclickBrowseOpen(View v) {

        Intent ScreenIntent1 = new Intent(this, BrowseActivity.class);

        startActivity(ScreenIntent1);
    }

    public void onclickAddbarOpen(View v) {

        Intent ScreenIntent1 = new Intent(this, AddbarActivity.class);

        startActivity(ScreenIntent1);
    }

    public void onclickSearchOpen(View v) {

        Intent ScreenIntent1 = new Intent(this, SearchActivity.class);

        startActivity(ScreenIntent1);
    }

    public void onclickHomeOpen(View v) {

        Intent ScreenIntent1 = new Intent(this, HomeActivity.class);

        startActivity(ScreenIntent1);
    }


}
