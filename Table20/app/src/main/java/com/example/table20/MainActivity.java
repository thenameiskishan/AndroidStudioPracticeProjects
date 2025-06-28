package com.example.table20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.edittext1);
        btn=findViewById(R.id.button1);
        textView=findViewById(R.id.textview);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1=et1.getText().toString();
                if(value1.equals(""))
                {
                    et1.setError("Please Enter Any Number");
                }
                else
                {
                    Integer ans=Integer.parseInt(value1);
                    int val,i;
                    for(i=1;i<=10;i++)
                    {
                        val=ans*i;
                       // textView.setText(textView.getText().toString()+ans+"*"+i+"="+val+"\n");
                        Toast.makeText(MainActivity.this, ans + "X" + i + "=" + val, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

}