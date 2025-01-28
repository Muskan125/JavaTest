package com.test.testui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.testui.Models.AnimalModel;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private Context context;
    List<AnimalModel> animalList;

    public  AnimalAdapter(Context context , List<AnimalModel> animalList){
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.animal_layout, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.AnimalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView animalName, breed, weight, isVeg , isDomestic;
        ImageView imageView;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            animalName = itemView.findViewById(R.id.animalName);
            breed = itemView.findViewById(R.id.animalBreed);
            weight = itemView.findViewById(R.id.animalWeight);
            isVeg = itemView.findViewById(R.id.isVeg);
            isDomestic = itemView.findViewById(R.id.domestic);
            imageView = itemView.findViewById(R.id.animalImg);
        }
    }
}
