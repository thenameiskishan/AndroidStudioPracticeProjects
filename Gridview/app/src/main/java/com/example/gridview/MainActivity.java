package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    List<String> brands=new ArrayList<>();
    ArrayAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid=findViewById(R.id.grid);
        brands.add("Samsung");
        brands.add("Apple");
        brands.add("Vivo");
        brands.add("Oppo");
        brands.add("Nokia");
        brands.add("Xiaomi");
        brands.add("OnePlus");
        brands.add("Realme");
        brands.add("Huawei");
        brands.add("HTC");
        brands.add("ASUS");
        brands.add("Sony");
        brands.add("Red Magic");
        brands.add("Motorola");
        brands.add("Gionee");



        adapter=new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,brands);

        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(MainActivity.this, ""+brands.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }
}