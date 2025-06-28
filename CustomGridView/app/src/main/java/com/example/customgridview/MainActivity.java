package com.example.customgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    productadapter adapter;
    private List<String> fname=new ArrayList<>();
    private List<String> fprice=new ArrayList<>();
    private List<Integer> fimg= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid=findViewById(R.id.grid);
        fname.add("Apple");
        fname.add("Banana");
        fname.add("Mango");
        fname.add("Grapes");
        fname.add("Kiwi");

        fprice.add("100/-");
        fprice.add("150/-");
        fprice.add("200/-");
        fprice.add("250/-");
        fprice.add("300/-");

        fimg.add(R.drawable.apple);
        fimg.add(R.drawable.banana);
        fimg.add(R.drawable.mango);
        fimg.add(R.drawable.grapes);
        fimg.add(R.drawable.kiwi);

        adapter=new productadapter(MainActivity.this,R.layout.row_item1,fname,fprice,fimg);
        grid.setAdapter(adapter);

    }
}