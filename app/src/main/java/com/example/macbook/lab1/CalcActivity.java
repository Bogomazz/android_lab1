package com.example.macbook.lab1;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.macbook.lab1.tools.Calculator;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        textView = (TextView) findViewById(R.id.calcInput);

        ((Button) findViewById(R.id.evalBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(""+Calculator.eval(textView.getText().toString()));
            }
        });

        ((Button) findViewById(R.id.clearBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        });
    }

    @Override
    public void onClick(View view) {
        textView.append(((Button)view).getText());
    }
}
