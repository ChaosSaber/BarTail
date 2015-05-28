package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.karsten_adolf.bartail_demo.DBFiles.AsyncRegister;
import com.example.karsten_adolf.bartail_demo.DBFiles.User;
import com.example.karsten_adolf.bartail_demo.helper.Hash;

import static com.example.karsten_adolf.bartail_demo.R.string.wrong_passwordConfirm;


public class RegisterActivity extends Activity {
    EditText ET_pass1;
    EditText ET_pass2;
    EditText ET_username;
    EditText ET_e_mail;
    TextView ausgabe;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);


        //Textfelder und Buttons deklarieren
        ET_pass1=(EditText)findViewById(R.id.et_pass);
        ET_pass2=(EditText)findViewById(R.id.et_pass2);
        ET_username=(EditText)findViewById(R.id.et_user);
        ET_e_mail=(EditText)findViewById(R.id.et_email);
        ausgabe=(TextView)findViewById(R.id.ausgabe);
        //Intent CallActivity = getIntent();
        //String PrevAct = CallActivity.getExtras().getString("stringput");

    }

    SuperclassActivity Super = new SuperclassActivity();


    public void onclickCancel(View v) {

        Intent ScreenIntent1 = new Intent(this, MainActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "RegisterActivity");
        startActivity(ScreenIntent1);
    }

    public void onclickRegister2(View v) {
        Hash hash = new Hash();
        String clear_username, clear_email;


        //Abfrage ob Email leer gelassen wurde
        if(!ET_e_mail.getText().toString().equals("")) {
            clear_email = ET_e_mail.getText().toString();

            
            //Abfrage ob Username leer gelassen wurde
            if (!ET_username.getText().toString().equals("")) {
                clear_username = ET_username.getText().toString();

                //Abfrage ob Passwörter übereinstimmen
                if (!ET_pass1.getText().toString().equals("") && !ET_pass2.getText().toString().equals("")) {

                    if (ET_pass1.getText().toString().equals(ET_pass2.getText().toString())) {

                        final User user = new User(clear_username, clear_email, hash.hashing(ET_pass1.getText().toString()));
                        AsyncRegister aRegister = new AsyncRegister(context, user);
                        aRegister.execute();
                    }
                    else {
                        Toast toast = Toast.makeText(this, R.string.wrong_passwordConfirm, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(this, R.string.empty_password, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else {
                Toast toast = Toast.makeText(this, R.string.empty_username, Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else {
            Toast toast = Toast.makeText(this, R.string.empty_email, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

 /*       Intent ScreenIntent1 = new Intent(this, LoginActivity.class);

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
*/