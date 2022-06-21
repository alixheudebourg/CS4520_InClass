package com.example.cs4520_inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cs4520_inclass.inClass3.InClass03Activity;
import com.example.cs4520_inclass.inClass4.InClass04;
import com.example.cs4520_inclass.inClass5.InClass05;
import com.example.cs4520_inclass.inClass6.InClass06;
import com.example.cs4520_inclass.inclass2.EditProfile;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button inClass1, inClass2, inClass3, inClass4, inClass5, inClass6, inClass7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inClass1 = findViewById(R.id.button_inClass1);
        inClass2 = findViewById(R.id.button_inClass2);
        inClass3 = findViewById(R.id.button_inClass3);
        inClass4 = findViewById(R.id.button_inClass4);
        inClass5 = findViewById(R.id.button_inClass5);
        inClass6 = findViewById(R.id.button_inClass6);
        //inClass7 = findViewById(R.id.button_inClass7);

        inClass1.setOnClickListener(this);
        inClass2.setOnClickListener(this);
        inClass3.setOnClickListener(this);
        inClass4.setOnClickListener(this);
        inClass5.setOnClickListener(this);
        inClass6.setOnClickListener(this);
        //inClass7.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_inClass1) {
            //Intent toInClass1 = new Intent(MainActivity.this, BMI_Calculator.class);
            //startActivity(toInClass1);
            Toast.makeText(this, "In Class 1 is not in this file.", Toast.LENGTH_LONG).show();
        }

        if (v.getId() == R.id.button_inClass2) {
            Intent toInClass2 = new Intent(MainActivity.this, EditProfile.class);
            startActivity(toInClass2);
        }

        if (v.getId() == R.id.button_inClass3) {
            Intent toInClass2 = new Intent(MainActivity.this, InClass03Activity.class);
            startActivity(toInClass2);
        }

        if (v.getId() == R.id.button_inClass4) {
            Intent toInClass4 = new Intent(MainActivity.this, InClass04.class);
            startActivity(toInClass4);
        }

        if (v.getId() == R.id.button_inClass5) {
            Intent toInClass5 = new Intent(MainActivity.this, InClass05.class);
            startActivity(toInClass5);
        }

        if (v.getId() == R.id.button_inClass6) {
            Intent toInClass6 = new Intent(MainActivity.this, InClass06.class);
            startActivity(toInClass6);
        }

        if (v.getId() == R.id.button_inClass7) {
            //Intent toInClass7 = new Intent(MainActivity.this, LoginActivity.class);
            //startActivity(toInClass7);
        }


    }

    // code from Winnie for assignment 06
    public static void showToast(Context contxt, String toastMsg) {
        Toast.makeText(contxt, toastMsg, Toast.LENGTH_SHORT).show();
    }
}