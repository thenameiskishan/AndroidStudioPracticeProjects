package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt=findViewById(R.id.edt);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1=edt.getText().toString();
                if (value1.equals(""))
                {
                    edt.setError("Please enter your name");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Your name is: "+value1, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}