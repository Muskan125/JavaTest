//https://youtu.be/YxZ7Dm2HD-A?si=CpRr3VEeAB3wgAFb - Recycler All Explained

package com.test.testui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Page4 extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4_activity);
        recyclerView = findViewById(R.id.recycle_linear);


    }
}
