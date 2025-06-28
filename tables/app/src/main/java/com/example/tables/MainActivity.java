package com.example.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kotlin.jvm.internal.Lambda;

public class MainActivity extends AppCompatActivity {
    EditText value;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value=findViewById(R.id.value);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = value.getText().toString();
                if (number.equals(" ")) {
                    value.setError("enter the value");
                } else {
                    int no = Integer.parseInt(number);
                    for (int x = 1; x <= 10; x++) {
                        int ans = no * x;
                        Toast.makeText(MainActivity.this, no + "X" + x + "=" + ans, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}