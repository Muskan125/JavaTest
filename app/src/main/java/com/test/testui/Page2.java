package com.test.testui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Page2 extends AppCompatActivity {
    String name;
    TextView nametext ;
    Button sendData;
    SharedPreferences preferences;
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2_activity);
        Button name_btn = findViewById(R.id.input_btn);
        sendData = findViewById(R.id.sendData);
        nametext = findViewById(R.id.username);
        name_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleInputText();
            }
        });
    }

    private void handleInputText() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.name_input_dialog);

        EditText input = dialog.findViewById(R.id.input_text);
        Button submit = dialog.findViewById(R.id.submit);
        Button cancel = dialog.findViewById(R.id.cancel);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = input.getText().toString().trim();
                if (!name.isEmpty()) {
                    nametext.setText(name);
                    dialog.dismiss();
                    preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    edit = preferences.edit();
                    edit.putString("nameData", name);
                    edit.apply();
                    sendData.setEnabled(true);
                    sendData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sendData();
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Field can't be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void sendData(){
        if(!name.isEmpty())
        {
            Intent page3 = new Intent(this, Page3.class);
            page3.putExtra("nameData", name);
            startActivity(page3);
        }
        else {
            Toast.makeText(this, "Enter A Valid Name", Toast.LENGTH_SHORT).show();
        }
    }
}

// Rough Codes

//    private void showNameInputDialog() {
//        final EditText input = new EditText(this);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Enter Your Name")
//                .setMessage("Please enter your name below:")
//                .setView(input)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                         name = input.getText().toString().trim();
//                        if (!name.isEmpty()) {
//                            nametext = findViewById(R.id.username);
//                            nametext.setText("Your name is : " + name);
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Name cannot be empty", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//        builder.create().show();
//    }