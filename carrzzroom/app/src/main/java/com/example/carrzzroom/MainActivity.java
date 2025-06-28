package com.example.carrzzroom;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;



        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    car_front adapter;
    private List<String> carname=new ArrayList<>();
    private List<String> carprice=new ArrayList<>();
    private List<Integer> carimage= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.list);
        carname.add("Bugatti");
        carname.add("Rolls Royce");

        carprice.add("!!!");
        carprice.add("!!!");


        carimage.add(R.drawable.bugatti_logo);
        carimage.add(R.drawable.rolls_royce_logo);

        adapter=new car_front(MainActivity.this,R.layout.car_back,carname,carprice,carimage);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (carname.equals("Bugatti"))
                {

                }

            }
        });
    }
}