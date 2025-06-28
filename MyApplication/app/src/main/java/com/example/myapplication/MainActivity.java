package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.OnNewIntentProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=findViewById(R.id.radiogroup1);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rb=findViewById(rg.getCheckedRadioButtonId());
                Toast.makeText(MainActivity.this, "you have selected: "+rb.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}