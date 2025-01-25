package com.test.testui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    TextView defaultname, changename;
    String name1 = "Muskan";
    String name2 = "Shaikh";
    String[] kids = {"kid1","kid2","kid3","kid4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        defaultname = findViewById(R.id.text1);
        changename = findViewById(R.id.text2);
        defaultname.setText(name1);
        changename.setText(name2);
        Button default_btn = findViewById(R.id.default_name);
        Button chng = findViewById(R.id.change);
        Button next_btn = findViewById(R.id.next);
        default_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defaultname.setText(name1);
                changename.setText(name2);
                for(int i=0; i<kids.length;i++){
                    Log.d("KIDS", "mykid : "+ kids[i]);
                }
            }
        });

        chng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defaultname.setText(name2);
                changename.setText(name1);
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page2 = new Intent(MainActivity.this, Page2.class);
                startActivity(page2);
            }
        });
    }
}

//1.Pass Data Between Activities ✅
//2.Save User Input with SharedPreferences ✅
//3.Improve UI with RecyclerView
//4.Add Animations