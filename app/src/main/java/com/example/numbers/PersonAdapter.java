package com.example.numbers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> pepole;
    ItemSelected activity;

    public interface ItemSelected {
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context,ArrayList<Person> list){
        this.pepole=list;
        activity=(ItemSelected) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            imageView=itemView.findViewById(R.id.img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(pepole.indexOf(view.getTag()));
                }
            });

        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(pepole.get(position));
        holder.tvName.setText(pepole.get(position).getName());
        if(pepole.get(position).getImage()!=null)
        {holder.imageView.setImageResource(pepole.get(position).getImage());}
        else{
            holder.imageView.setImageResource(R.drawable.contact_phone);
        }
    }


    @Override
    public int getItemCount() {
        return pepole.size();
    }


}
