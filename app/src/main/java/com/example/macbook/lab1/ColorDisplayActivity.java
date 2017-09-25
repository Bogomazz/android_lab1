package com.example.macbook.lab1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.Button;
import android.widget.SeekBar;

public class ColorDisplayActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    String red = "00", green = "00", blue = "00";
    Button colorDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_display);

        colorDisplay = (Button) findViewById(R.id.colorDisplayBtn);

        ((SeekBar) findViewById(R.id.redSeek)).setOnSeekBarChangeListener(this);
        ((SeekBar) findViewById(R.id.blueSeek)).setOnSeekBarChangeListener(this);
        ((SeekBar) findViewById(R.id.greenSeek)).setOnSeekBarChangeListener(this);
    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(seekBar.getId() == R.id.blueSeek){
            this.blue = seekDataToColorString(i);
        } if(seekBar.getId() == R.id.redSeek){
            this.red = seekDataToColorString(i);
        } if(seekBar.getId() == R.id.greenSeek){
            this.green = seekDataToColorString(i);
        }

        colorDisplay.setBackgroundColor(Color.parseColor("#" + this.red + this.green + this.blue));
    }

    private String seekDataToColorString(int value) {
        String hexColorString = Integer.toHexString((int) (((double) value / 100)*255));
        String result = hexColorString.length() > 1 ? hexColorString : "0" + hexColorString;
        return result;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
