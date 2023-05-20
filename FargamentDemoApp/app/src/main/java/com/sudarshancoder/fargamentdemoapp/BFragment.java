package com.sudarshancoder.fargamentdemoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class BFragment extends Fragment {


    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_b, container, false);

        EditText user = view.findViewById(R.id.username);
        EditText name = view.findViewById(R.id.name);
        EditText pass = view.findViewById(R.id.password);
        Button signup = view.findViewById(R.id.signup);

        signup.setOnClickListener(View ->{
            Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_SHORT).show();
        });


        return  view;
    }
}