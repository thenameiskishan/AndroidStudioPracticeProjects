package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbar;
    Button btn;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar=findViewById(R.id.seekbar);
        btn=findViewById(R.id.btn);
        text=findViewById(R.id.text);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean isuser) {

                if (isuser)
                {
                    text.setText(""+progress);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Toast.makeText(MainActivity.this, "started...", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Toast.makeText(MainActivity.this, "stopped", Toast.LENGTH_SHORT).show();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, ""+seekbar.getProgress(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}