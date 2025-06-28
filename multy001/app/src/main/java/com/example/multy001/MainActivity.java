package com.example.multy001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView plus1;
    TextView no1;
    TextView minus1;
    TextView plus2;
    TextView no2;
    TextView minus2;
    TextView multiply;
    TextView out;
    TextView ans;
    int x=0;
    int y=0;
    int z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        plus1=findViewById(R.id.plus1);
        no1=findViewById(R.id.no1);
        minus1=findViewById(R.id.minus1);
        plus2=findViewById(R.id.plus2);
        no2=findViewById(R.id.no2);
        minus2=findViewById(R.id.minus2);
        multiply=findViewById(R.id.multiply);
        ans=findViewById(R.id.ans);
        out=findViewById(R.id.out);

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 x++;
                 no1.setText(""+x);
            }
        });
        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x--;
                no1.setText(""+x);
            }
        });
        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y++;
                no2.setText(""+y);
            }
        });
        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y--;
                no2.setText(""+y);
            }
        });
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(""+x*y);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(""+x*y);
            }
        });

    }
}