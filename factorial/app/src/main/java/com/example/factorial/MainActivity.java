package com.example.factorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int f=1;
    EditText edt;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt=findViewById(R.id.edt);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String number=edt.getText().toString();
                if(number.equals("")) {
                    edt.setError("enter the number");
                }
                else{
                    int last=Integer.parseInt(number);
                    for(int x=1;x<=last;x++) {
                        f*=x;
                    }
                    Toast.makeText(MainActivity.this, "Factorial is: "+f, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}