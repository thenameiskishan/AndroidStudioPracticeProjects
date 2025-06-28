package com.example.p_mtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button plus;
    Button minus;
    Button reset;
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text);
        minus=findViewById(R.id.minus);
        plus=findViewById(R.id.plus);
        reset=findViewById(R.id.reset);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(MainActivity.this, "no. is: "+text.getText().toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this, "hello "+text.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
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
    }
}