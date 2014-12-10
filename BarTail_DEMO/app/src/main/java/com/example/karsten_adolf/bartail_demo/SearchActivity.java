package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class SearchActivity extends Activity {
    SeekBar sb;
    TextView tv;

    private Spinner PriceSpinner, MusicSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        //DISTANCE SEEKBAR CODE |
        sb = (SeekBar) findViewById(R.id.seekBar);
        tv = (TextView) findViewById(R.id.search_distance);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(String.valueOf(progress)+ " km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        addItemsToSpinner_Price();
        //addListenerToSpinner_Price();
        addItemsToSpinner_Music();
        //ItemMusicClickListener();

    }

    public void onclickAddbar(View v) {
        Intent ScreenIntent1 = new Intent(this, AddbarActivity.class);

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

    public void addItemsToSpinner_Price(){
        PriceSpinner = (Spinner) findViewById(R.id.spinner_price);
        ArrayAdapter<CharSequence> PriceSpinnerAdapter=
                ArrayAdapter.createFromResource(this, R.array.spinner_type_price, android.R.layout.simple_spinner_item);
        PriceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PriceSpinner.setAdapter(PriceSpinnerAdapter);
    }

    public void addItemsToSpinner_Music(){
        MusicSpinner = (Spinner) findViewById(R.id.spinner_music);
        ArrayAdapter<CharSequence> MusicSpinnerAdapter=
                ArrayAdapter.createFromResource(this, R.array.spinner_type_music, android.R.layout.simple_spinner_item);
        MusicSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MusicSpinner.setAdapter(MusicSpinnerAdapter);
    }

    public void onclickBack(View v) {
        Intent ScreenIntent1 = new Intent(this, HomeActivity.class);

        final int result = 1;

        //ScreenIntent1.putExtra("stringput", "LoginActivity");
        startActivity(ScreenIntent1);
    }


    public void onclickSearch(View v) {
        Intent ScreenIntent1 = new Intent(this, SearchResultActivity.class);

        EditText BarNameET = (EditText) findViewById(R.id.editText7);
        String BarName = String.valueOf(BarNameET.getText());

        SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
        Integer BarDistance = sb.getProgress();

        String BarMusic = MusicSpinner.getSelectedItem().toString();

        String BarPrice = PriceSpinner.getSelectedItem().toString();

        EditText BarTimeET1 = (EditText) findViewById(R.id.search_time1);
        EditText BarTimeET2 = (EditText) findViewById(R.id.search_time2);
        String BarTime1 = String.valueOf(BarTimeET1.getText());
        String BarTime2 = String.valueOf(BarTimeET2.getText());

        final int result = 1;

        ScreenIntent1.putExtra("BarName", BarName);
        ScreenIntent1.putExtra("BarDistance", BarDistance);
        ScreenIntent1.putExtra("BarMusic", BarMusic);
        ScreenIntent1.putExtra("BarPrice", BarPrice);
        ScreenIntent1.putExtra("BarTime1", BarTime1);
        ScreenIntent1.putExtra("BarTime2", BarTime2);


        startActivity(ScreenIntent1);

    }


}
