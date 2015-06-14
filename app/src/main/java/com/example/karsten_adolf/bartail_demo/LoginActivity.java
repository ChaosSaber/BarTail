package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends Activity {

    EditText et_e_mail;
    EditText et_Passwort;
    TextView ausgabe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        et_e_mail=(EditText)findViewById(R.id.et_user);
        et_Passwort=(EditText)findViewById(R.id.et_pass);
        ausgabe=(TextView)findViewById(R.id.ausgabe);


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

        String e_mail=et_e_mail.getText().toString();
        String passwort=et_Passwort.getText().toString();
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        User nutzer = dbHandler.UserLogin(e_mail,passwort);
        if(nutzer==null)
        {
            ausgabe.setText("E-Mail oder Passwort falsch");
            return;
        }
        ((MyApplication) this.getApplication()).setUser_ID(nutzer.getUser_ID());
        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }
}
