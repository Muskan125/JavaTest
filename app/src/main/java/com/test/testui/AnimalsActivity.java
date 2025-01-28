package com.test.testui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.testui.Models.AnimalModel;

import java.util.ArrayList;
import java.util.List;

public class AnimalsActivity extends AppCompatActivity {
    RecyclerView animal_recyclerView;
    List<AnimalModel> animalList;
    AnimalAdapter animalAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_recycler);
        animal_recyclerView = findViewById(R.id.animal_recycler_view);
        animal_recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        animalList = getDataFromJson();

    }
    private List<AnimalModel> getDataFromJson(){
        List<AnimalModel> animalsData = new ArrayList<>();
        try{

        }
        catch (Exception e){
            Log.d("AnimalsActivity", "AnimalsActivity : "+ e);
        }

        return animalsData;
    }
}
