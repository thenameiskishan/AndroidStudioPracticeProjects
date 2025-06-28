package com.example.plusminus20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    TextView plus;
    TextView minus;
    TextView reset;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.out);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        reset=findViewById(R.id.reset);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x++;
                text.setText(""+x);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x--;
                text.setText(""+x);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x=0;
                text.setText("0");
            }
        });
    }
}