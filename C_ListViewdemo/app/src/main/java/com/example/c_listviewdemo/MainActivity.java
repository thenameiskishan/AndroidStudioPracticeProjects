package com.example.c_listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.c_listviewdemo.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ProductAdapter adapter;
    private List<String> fruitNames=new ArrayList<>();
    private List<String> fruitPrices=new ArrayList<>();
    private List<Integer> fruitImages=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        fruitNames.add("Apple");
        fruitNames.add("Banana");
        fruitNames.add("Mango");
        fruitNames.add("Grapes");
        fruitNames.add("Kiwi");

        fruitPrices.add("100/-");
        fruitPrices.add("150/-");
        fruitPrices.add("200/-");
        fruitPrices.add("250/-");
        fruitPrices.add("300/-");

        fruitImages.add(R.drawable.apple);
        fruitImages.add(R.drawable.banana);
        fruitImages.add(R.drawable.mango);
        fruitImages.add(R.drawable.grapes);
        fruitImages.add(R.drawable.kiwi);

        adapter=new ProductAdapter(MainActivity.this,R.layout.row_item1,fruitNames,fruitPrices, fruitImages);
        listView.setAdapter(adapter);
    }
}