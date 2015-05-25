package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends Activity {

    Button buttonBrowse,buttonSearch,buttonAddBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        buttonBrowse=(Button)findViewById(R.id.but_browse_top);
        buttonSearch=(Button)findViewById(R.id.but_search_top);
        buttonAddBar=(Button)findViewById(R.id.but_addbar_top);
        //Intent CallActivity = getIntent();
        //String PrevAct = CallActivity.getExtras().getString("stringput");
    }

    SuperclassActivity Super = new SuperclassActivity();

    public void onclickSearch(View v) {
        Intent ScreenIntent1 = new Intent(this, SearchActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }

    public void onclickBrowse(View v) {
        Intent ScreenIntent1 = new Intent(this, BrowseActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }

    public void onclickAddbar(View v) {
        Intent ScreenIntent1 = new Intent(this, AddbarActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }
}
