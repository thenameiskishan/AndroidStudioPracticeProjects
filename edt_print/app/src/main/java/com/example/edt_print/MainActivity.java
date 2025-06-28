package com.example.edt_print;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    EditText out,in;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        out=findViewById(R.id.out);
        in=findViewById(R.id.in);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value=in.getText().toString();

                if (value.equals("")) {

                    in.setError("enter value...");

                }
                else {

                    out.setText(""+value);

                }

            }
        });

    }
}