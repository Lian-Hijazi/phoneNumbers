package com.example.numbers;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemSelected {
    public static ArrayList<Person> people;
    TextView tvDate;
    String CurrentDate;
    Calendar calendar=Calendar.getInstance();
    FragmentManager fragmentManager;
    listFrag listFrag;
    detailsFrag detailsFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate=findViewById(R.id.tvDate);
        CurrentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        tvDate.setText(CurrentDate);
        fragmentManager=this.getSupportFragmentManager();
        listFrag=(listFrag)fragmentManager.findFragmentById(R.id.listFrag);
        intArray();
        detailsFrag=(detailsFrag)fragmentManager.findFragmentById(R.id.detailFrag);
        }



    public void intArray(){
        people=new ArrayList<>();
        Person person=new Person("Mrwan","0524514524",R.drawable.hbobder);
        people.add(person );
        person=new Person("Frial","0537895524",R.drawable.frial);
        people.add(person );
        person=new Person("Sdoad","0524578924",R.drawable.soad);
        people.add(person );
        person=new Person("Nadia","0524458824",R.drawable.nadia);
        people.add(person );
        person=new Person("Wawy","0524585621",R.drawable.wawy);
        people.add(person );

    }

    public void onItemClicked(int Index) {
        if(!people.isEmpty()) {
                detailsFrag.updateTexts(people.get(Index).getName(), people.get(Index).getPhone(),people.get(Index).getImage());
        }
        else
            return ;
    }

}