package com.example.emoji;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView cry,smile,happy,laugh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cry=findViewById(R.id.cry);
        smile=findViewById(R.id.smile);
        happy=findViewById(R.id.happy);
        laugh=findViewById(R.id.laugh);
        cry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "cry", Toast.LENGTH_SHORT).show();
            }
        });
        smile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "smile", Toast.LENGTH_SHORT).show();
            }
        });
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "happy", Toast.LENGTH_SHORT).show();
            }
        });
        laugh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "laugh", Toast.LENGTH_SHORT).show();
            }
        });
    }
}