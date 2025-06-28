package com.example.spinnernew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    List<String> city=new ArrayList<>();
    ArrayAdapter dropdown=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);

        city.add("Mohenjo Daro");
        city.add("Harappa");
        city.add("Indus Vally");
        city.add("Kadamba");
        city.add("Vakataka");
        dropdown.new ArrayAdapter(MainActivity.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,city);
        spinner.setAdapter(dropdown);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+city.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}