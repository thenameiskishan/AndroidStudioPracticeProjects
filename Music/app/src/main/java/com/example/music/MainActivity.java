package com.example.music;

import android.media.MediaPlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends AppCompatActivity {

    ListView list;
    List<String> song=new ArrayList<>();
    ArrayAdapter adapter=null;
    MediaPlayer music;

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.list);
           song.add("song 1");
           song.add("song 2");
           song.add("song 3");
           song.add("song 4");
           song.add("song 5");

        adapter=new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,song);

        list.setAdapter(adapter);

//        music = MediaPlayer.create(
//                this, R.raw.sound);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }


    public void musicplay(View v)
    {

        music.start();
    }


    public void musicpause(View v)
    {

        music.pause();
    }


    public void musicstop(View v)
    {
        music.stop();
        music
                = MediaPlayer.create(this, R.raw.sound);
    }
}