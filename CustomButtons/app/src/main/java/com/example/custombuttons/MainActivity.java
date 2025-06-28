package com.example.custombuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn11,btn22,btn33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn11=findViewById(R.id.btn1);
        btn22=findViewById(R.id.btn2);
        btn33=findViewById(R.id.btn3);

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Oval button has been pressed", Toast.LENGTH_SHORT).show();
            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Rectangle button has been pressed", Toast.LENGTH_SHORT).show();
            }
        });

        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cylinder button has been pressed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}