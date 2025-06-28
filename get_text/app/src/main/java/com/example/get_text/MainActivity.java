package com.example.get_text;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    EditText edt2;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String out1=edt1.getText().toString();
                String out2=edt2.getText().toString();
                if(out1.equals(""))
                {
                    edt1.setError("enter your first name");
                }
                else if(out2.equals(""))
                {
                    edt2.setError("enter your last name");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "your full name is: "+out1+" "+out2, Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}