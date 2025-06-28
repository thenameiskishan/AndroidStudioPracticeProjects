

package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CheckBox c1,c2,c3,c4;
    Button btn;
    TextView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);
        btn=findViewById(R.id.btn);
        out=findViewById(R.id.out);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text="You have selected:\n";
                if(c1.isChecked())
                {
                    text=text+c1.getText().toString()+"\n";
                    c1.setTextColor(Color.parseColor("Red"));
                }
                if(c2.isChecked())
                {
                    text=text+c2.getText().toString()+"\n";
                    c2.setTextColor(Color.parseColor("Yellow"));
                }
                if(c3.isChecked())
                {
                    text=text+c3.getText().toString()+"\n";
                    c3.setTextColor(Color.parseColor("purple"));
                }
                if(c4.isChecked())
                {
                    text=text+c4.getText().toString();
                    c4.setTextColor(Color.parseColor("Green"));
                }
               Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();


                out.setText(text);
            }
        });
    }
}