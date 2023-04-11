package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListData> {

    public ListAdapter(@NonNull Context context, ArrayList<ListData> dataArrayList) {
        super(context, R.layout.list_items, dataArrayList);

    }

    public View getView(int position, View view, ViewGroup parent){
        ListData listData = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);

        }
        ImageView listImage = view.findViewById(R.id.listImage);
        TextView listName = view.findViewById(R.id.listname);
        TextView listFounder = view.findViewById(R.id.listFounder);


        listImage.setImageResource(listData.image);
        listName.setText(listData.name);
        listFounder.setText(listData.founder);


        return view;
    }
}
