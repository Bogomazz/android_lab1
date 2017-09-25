package com.example.macbook.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button colorDisplayButton = (Button) findViewById(R.id.colorDisplay);
        final Button calcButton = (Button) findViewById(R.id.calc);
        final Button notesButton = (Button) findViewById(R.id.notes);

        final Intent colorDisplayIntent = new Intent(this, ColorDisplayActivity.class);
        final Intent calcIntent = new Intent(this, CalcActivity.class);
        final Intent notesIntent = new Intent(this, NotesActivity.class);

        colorDisplayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(colorDisplayIntent);
            }
        });
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(calcIntent);
            }
        });
        notesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(notesIntent);
            }
        });
    }
}
