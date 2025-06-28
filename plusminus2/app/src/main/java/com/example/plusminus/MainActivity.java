package com.example.plusminus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView show;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show=findViewById(R.id.print);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x++;
                show.setText(""+x);
            }
        });
    }
}