package com.example.customgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class productadapter extends ArrayAdapter {

    private Context context;
    private int resources;
    private List<String> titles;
    private List<String> subtitles;
    private List<Integer> images;

    public productadapter(@NonNull Context context, int resources, List<String> titles, List<String> subtitle, List<Integer> images){

        super(context, resources, titles);
        this.titles=titles;
        this.subtitles=subtitle;
        this.images=images;
        this.context=context;
        this.resources=resources;

    }
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){

        LayoutInflater inflater=LayoutInflater.from(context);
        View item=inflater.inflate(resources,parent,false);
        ImageView img=item.findViewById(R.id.img);
        TextView title=item.findViewById(R.id.title);
        TextView subtitle=item.findViewById(R.id.subtitle);
        img.setImageResource(images.get(position));
        title.setText(titles.get(position));
        subtitle.setText(subtitles.get(position));
        return item;

    }



}
