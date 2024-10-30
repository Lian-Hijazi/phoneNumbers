package com.example.numbers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addFrag extends Fragment {


    private EditText etName,etPhone;
    private Button add;

    public addFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add, container, false);
        etName=view.findViewById(R.id.etName);
        etPhone=view.findViewById(R.id.etPhone);
        add=view.findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if( etName.getText().toString().trim().isEmpty()||etPhone.getText().toString().trim().isEmpty())
                   Toast.makeText(getActivity(),"please fill all fields",Toast.LENGTH_SHORT).show();
               else{
                   String name,phone;
                   name=etName.getText().toString().trim();
                   phone=etPhone.getText().toString().trim();
                   MainActivity.people.add(new Person(name,phone));
                   Toast.makeText(getActivity(),"person added successfully",Toast.LENGTH_SHORT).show();
                   listFrag.notifyDataSetChanged();
               }
            }
        });
        return view;
    }
}