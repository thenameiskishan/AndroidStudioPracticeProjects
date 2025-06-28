package com.example.imageradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=findViewById(R.id.rg);
        image=findViewById(R.id.image);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton rb=findViewById(checkedId);
                Toast.makeText(MainActivity.this, ""+rb.getText().toString(), Toast.LENGTH_SHORT).show();
                switch (checkedId)
                {
                    case R.id.apple:
                        image.setImageResource(R.drawable.apple);
                        break;
                    case R.id.banana:
                        image.setImageResource(R.drawable.banana);
                        break;
                    case R.id.mango:
                        image.setImageResource(R.drawable.mango);
                        break;
                    case R.id.grapes:
                        image.setImageResource(R.drawable.grapes);
                        break;
                    case R.id.kiwi:
                        image.setImageResource(R.drawable.kiwi);
                        break;
                }
            }
        });

    }
}