package com.example.ccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edt1, edt2;
    Button plus, minus, multy, div, clear;
    TextView ans;

    float no1, no2;


    public float getFromEdit(EditText editText)
    {

        return (editText.getText().toString().equals("")) ? 0 : Float.parseFloat(editText.getText().toString());

    }



    public void setValue(float value)
    {
        ans.setText(String.valueOf(value));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multy = findViewById(R.id.multy);
        div = findViewById(R.id.div);

        clear = findViewById(R.id.clear);

        ans = findViewById(R.id.ans);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multy.setOnClickListener(this);
        div.setOnClickListener(this);
        clear.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        no1 = getFromEdit(edt1);
        no2 = getFromEdit(edt2);

        int ViewID = v.getId();

        if(ViewID == R.id.plus)
        {

            setValue(no1+no2);
//            ans.setText("Answer = " + (no1 + no2));
        }
        else if (ViewID == R.id.minus)
        {
            setValue(no1-no2);
        }
        else if(ViewID == R.id.multy)
        {
            setValue(no1*no2);
        }
        else if (ViewID == R.id.div)
        {
            if((no1 == 0) || (no2 == 0))
            {
                ans.setText("NaN");
            }
            else
            {
                setValue(no1/no2);
            }

        }
        else if (ViewID == R.id.clear)
        {
            ans.setText("--");
        }


    }

}