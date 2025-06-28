package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText value1,value2;
    TextView ans;
    Button plus,minus,multi,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value1=findViewById(R.id.value1);
        value2=findViewById(R.id.value2);
        ans=findViewById(R.id.ans);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multi =findViewById(R.id.multy);
        div=findViewById(R.id.div);

        String no1=value1.getText().toString();
        String no2=value2.getText().toString();
        if(no1.equals(" "))
        {
            value1.setError("enter 1st value");
        }
        else if(no2.equals(" "))
        {
            value2.setError("enter 2nd value");
        }
        else
        {

            int n1=Integer.parseInt(no1);
            int n2=Integer.parseInt(no2);
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ans.setText(n1+n2);
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ans.setText(n1-n2);
                }
            });
            multi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ans.setText(n1*n2);
                }
            });
            div.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ans.setText(n1/n2);
                }
            });
        }

    }
}