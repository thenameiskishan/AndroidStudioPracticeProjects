package com.example.sql_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<String> ids;
    private List<String> names;
    private List<String> cities;

    public MyAdapter(Context context, int resource, List<String> ids, List<String> names, List<String> cities){
        super(context,resource,ids);
        this.context=context;
        this.resource=resource;
        this.ids=ids;
        this.names=names;
        this.cities=cities;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=LayoutInflater.from(context);
        View items= inflater.inflate(resource,parent,false);
        TextView id=items.findViewById(R.id.textId);
        TextView name=items.findViewById(R.id.textName);
        TextView city= items.findViewById(R.id.textCity);
        id.setText(ids.get(position));
        name.setText(names.get(position));
        city.setText(cities.get(position));
        return items;
    }

}
