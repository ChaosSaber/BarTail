package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class RegisterActivity extends Activity {
    EditText ET_pass1;
    EditText ET_pass2;
    EditText ET_username;
    EditText ET_e_mail;
    TextView ausgabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        ET_pass1=(EditText)findViewById(R.id.et_pass);
        ET_pass2=(EditText)findViewById(R.id.et_pass2);
        ET_username=(EditText)findViewById(R.id.et_user);
        ET_e_mail=(EditText)findViewById(R.id.et_email);
        ausgabe=(TextView)findViewById(R.id.ausgabe);
        //Intent CallActivity = getIntent();
        //String PrevAct = CallActivity.getExtras().getString("stringput");
    }

    public void onclickCancel(View v) {

        Intent ScreenIntent1 = new Intent(this, MainActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "RegisterActivity");
        startActivity(ScreenIntent1);
    }

    public void onclickRegister2(View v) {

        Intent ScreenIntent1 = new Intent(this, LoginActivity.class);

        String passwort1=ET_pass1.getText().toString();
        String passwort2=ET_pass2.getText().toString();
        User nutzer;
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        if(dbHandler.findUser(ET_e_mail.getText().toString())!=null) {
            ausgabe.setText("Diese E-Mail adresse ist bereits registriert");
        }
        else if(!passwort1.equals(passwort2))
        {
            ausgabe.setText("Die Passwortwiederhohlung ist falsch");
        }
        else {
            nutzer = new User(ET_username.getText().toString(), ET_e_mail.getText().toString(), passwort1);
            dbHandler.AddUser(nutzer);
            nutzer=dbHandler.findUser(ET_e_mail.getText().toString());
            ausgabe.setText("Registrierung erfolgreich");
            ((MyApplication) this.getApplication()).setUser_ID(nutzer.getUser_ID());
            startActivity(ScreenIntent1);
        }

    }
}
