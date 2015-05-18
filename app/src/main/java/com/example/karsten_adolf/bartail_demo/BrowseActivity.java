package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class BrowseActivity extends Activity {
    private static Bar[] Bars=null;/*=new Bar[]{
        new Bar(0,"Cocktailbar","Kriegsstra�e 20","76149","Karlsruhe", "19:00","01:00","","eine Cocktailbar","Country"),
        new Bar(1,"Stadtkneipe","Kaiserstra�e 95","76149","Karlsruhe", "20:00","02:00","","eine Stadtkneipe","Jazz"),
        new Bar(2,"Jazzbar","Sudetenstra�e 45","76187","Karlsruhe", "17:00","01:00","","eine Jazzbar","Jazz"),
        new Bar(3,"Studentenbar","Tennesseeallee 8","76149","Karlsruhe", "15:00","20:00","","eine Studentenbar","gemischt"),
        new Bar(4,"Studentenbar an der DH","Erzbergerstra�e 103","76149","Karlsruhe", "08:00","18:00","","noch eine Studentenbar","Country"),
        new Bar(5,"Studentenbar Faulheit","Bierstra�e 3","76149","Karlsruhe", "0:00","24:00","","noch eine Studentenbar, weil ich keine Lust hatte mir etwas anderes asuzudenken","Rock")
    };*/
    private static int index =0;
    TextView tv_name,tv_adresse,tv_beschreibung, tv_oeffnungszeiten,tv_musikrichtung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_layout);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        if(Bars==null)
            Bars = dbHandler.findBars();
        tv_name=(TextView)findViewById(R.id.tv_a_barname);
        tv_adresse=(TextView)findViewById(R.id.tv_a_address);
        tv_beschreibung=(TextView)findViewById(R.id.tv_a_description);
        tv_oeffnungszeiten =(TextView)findViewById(R.id.tv_a_oeffnungszeiten);
        tv_musikrichtung=(TextView)findViewById(R.id.tv_a_musikrichtung);
        ShowBar();
    }

    SuperclassActivity Super = new SuperclassActivity();

    public void onclickSearch(View v) {
        Intent ScreenIntent1 = new Intent(this, SearchActivity.class);

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

    private void ShowBar()
    {
        if(Bars==null)return;
        index=index%Bars.length;
        ((MyApplication) this.getApplication()).setBar_ID(Bars[index].getID());
        tv_name.setText(Bars[index].getName());
        tv_adresse.setText(Bars[index].getAdresse()+","+Bars[index].getPLZ()+" "+Bars[index].getOrt());
        tv_beschreibung.setText(Bars[index].getBeschreibung());
        tv_oeffnungszeiten.setText(Bars[index].getOeffnungszeiten()+" - "+Bars[index].getSchliessungszeiten());
        tv_musikrichtung.setText(Bars[index].getMusikrichtung());
    }

    public void onclicknextBar(View v)
    {
        index++;
        ShowBar();
    }

    public void onclickprevBar(View v)
    {
        index--;
        ShowBar();
    }
    public void onclickbewerten(View v)
    {
        Intent ScreenIntent1 = new Intent(this, BewertenActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }
}
