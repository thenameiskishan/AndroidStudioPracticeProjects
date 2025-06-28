package com.example.plusminus30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int n=0;
    TextView text;
    TextView minus;
    TextView plus;
    TextView reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text);
        minus=findViewById(R.id.minus);
        plus=findViewById(R.id.plus);
        reset=findViewById(R.id.reset);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n--;
                text.setText(""+n);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n++;
                text.setText(""+n);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=0;
                text.setText("0");

            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "count is: "+n, Toast.LENGTH_SHORT).show();
            }
        });


    }
}