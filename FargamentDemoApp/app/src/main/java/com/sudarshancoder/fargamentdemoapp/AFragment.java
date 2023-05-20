package com.sudarshancoder.fargamentdemoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AFragment extends Fragment {



    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_a, container, false);

        EditText user = view.findViewById(R.id.username);
        EditText pass = view.findViewById(R.id.password);
        Button signin = view.findViewById(R.id.signin);

        signin.setOnClickListener(View ->{
            if(user.getText().toString().equals("sudarshan") && pass.getText().toString().equals("date2004")){
                Toast.makeText(getActivity(), "Welcome", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

            }
        });


        return  view;
    }
}