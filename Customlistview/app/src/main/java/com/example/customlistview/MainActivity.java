package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    productadapter adapter;
    private List<String> fname=new ArrayList<>();
    private List<String> fprice=new ArrayList<>();
    private List<Integer> fimg= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.list);
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
        list.setAdapter(adapter);

    }
}