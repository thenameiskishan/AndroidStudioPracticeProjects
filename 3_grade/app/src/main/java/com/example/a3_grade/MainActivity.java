package com.example.a3_grade;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText m1;
    EditText m2;
    EditText m3;
    Button submit;
    TextView out_total;
    TextView out_per;
    int total;
    float per;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m1=findViewById(R.id.m1);
        m2=findViewById(R.id.m2);
        m3=findViewById(R.id.m3);
        out_total=findViewById(R.id.out_total);
        out_per=findViewById(R.id.out_per);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m1.equals(" ")) {
                    m1.setError("Enter marks");
                }
                else if(m2.equals(" ")) {
                    m2.setError("Enter marks");
                }
                else if(m3.equals(" ")) {
                    m3.setError("Enter marks");
                }
                else {
                    String e1 = m1.getText().toString();
                    String e2 = m2.getText().toString();
                    String e3 = m3.getText().toString();
                    int n1 = Integer.parseInt(e1);
                    int n2 = Integer.parseInt(e2);
                    int n3 = Integer.parseInt(e3);
                    total = n1 + n2 + n3;
                    per = total / 3;
                    //Toast.makeText(MainActivity.this, "total is: " + total + "\npercentage are: " + per, Toast.LENGTH_SHORT).show();
                    if(per>=33) {
                        out_total.setText("total is: " + total);
                        out_per.setText("percantage are: " + per);
                        out_total.setTextColor(Color.parseColor("#0eb50e"));
                        out_per.setTextColor(Color.parseColor("#0eb50e"));
                    }
                    else {
                        out_total.setText("total is: " + total);
                        out_per.setText("percantage are: " + per);
                        out_total.setTextColor(Color.parseColor("#c21010"));
                        out_per.setTextColor(Color.parseColor("#c21010"));
                    }
                    }
            }
        });

    }
}