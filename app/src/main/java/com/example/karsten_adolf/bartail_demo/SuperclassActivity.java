package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Leon on 04.05.2015.
 */
public class SuperclassActivity extends Activity {

    private Button ButtonLogin, ButtonLoginAd, ButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_layout);

    };

    public void onclickLoginOpen(View v) {

        Intent ScreenIntent1 = new Intent(this, LoginActivity.class);

        final int result = 1;

        startActivity(ScreenIntent1);
    }

    public void onclickRegisterOpen(View v) {

        Intent ScreenIntent1 = new Intent(this, RegisterActivity.class);

        final int result = 1;

        startActivity(ScreenIntent1);
    }
}
