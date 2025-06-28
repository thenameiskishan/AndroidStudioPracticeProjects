package com.example.calc_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText screen;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button ac;
    Button clear;
    Button per;
    Button div;
    Button multy;
    Button minus;
    Button plus;
    Button equalss;
    Button dot;
    Button btn1;
    String vvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen=findViewById(R.id.screen);
        zero=findViewById(R.id.zero);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        ac=findViewById(R.id.ac);
        clear=findViewById(R.id.clear);
        per=findViewById(R.id.per);
        div=findViewById(R.id.div);
        multy=findViewById(R.id.multy);
        minus=findViewById(R.id.minus);
        plus=findViewById(R.id.plus);
        equalss=findViewById(R.id.equalss);
        dot=findViewById(R.id.dot);
        btn1=findViewById(R.id.btn1);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                

            }
        });

    }
}
