package com.example.imgzoom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.AnimationUtils;
public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button zin,zout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=findViewById(R.id.img);
        zin=findViewById(R.id.zin);
        zout=findViewById(R.id.zout);
        zin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zin.animate()
            }
        });

    }
}