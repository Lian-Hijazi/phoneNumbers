package com.example.numbers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class detailsFrag extends Fragment {

    private TextView tvName;
    private TextView phone;
    ImageView img;

    public detailsFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_details, container, false);
        tvName=view.findViewById(R.id.tvName);
        phone=view.findViewById(R.id.phone);
        img=view.findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  phoneNum=phone.getText().toString().trim();
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNum));
                startActivity(intent);
            }
        });

        return view;
    }

    public void updateTexts(String st1,String st2){
        tvName.setText(st1);
        phone.setText(st2);
    }
}