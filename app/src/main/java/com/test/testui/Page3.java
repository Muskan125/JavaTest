package com.test.testui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Page3 extends AppCompatActivity {
    TextView text1 , text2;
    SharedPreferences preferences;
    SharedPreferences.Editor edit;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3_activity);
        text1 = findViewById(R.id.myname);
        text2 = findViewById(R.id.myname2);
        Intent page3 = getIntent();
        text1.setText("Your Name Has Received : " + page3.getStringExtra("nameData"));

        preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        text2.setText("Your Name From Shared Preference : " + preferences.getString("nameData","unknown"));
        btn = findViewById(R.id.Page4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page4 = new Intent(getApplicationContext(), Page4.class);
                startActivity(page4);
            }
        });
    }
}
