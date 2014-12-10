package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        //Intent CallActivity = getIntent();
        //String PrevAct = CallActivity.getExtras().getString("stringput");
    }

    public void onclickCancel2(View v) {

        Intent ScreenIntent1 = new Intent(this, MainActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "RegisterActivity");
        startActivity(ScreenIntent1);
    }

    public void onclickLogin2(View v) {

        Intent ScreenIntent1 = new Intent(this, HomeActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }
}
