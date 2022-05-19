package com.example.cs4520_inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button inClass1, inClass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inClass1 = findViewById(R.id.button_inClass1);
        inClass2 = findViewById(R.id.button_inClass2);

        inClass1.setOnClickListener(this);
        inClass2.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_inClass1) {
            //Intent toInClass1 = new Intent(MainActivity.this, BMI_Calculator.class);
            //startActivity(toInClass1);
            Toast.makeText(this, "Invalid Inputs", Toast.LENGTH_LONG).show();
        }

        if (v.getId() == R.id.button_inClass2) {
            Intent toInClass2 = new Intent(MainActivity.this, EditProfile.class);
            startActivity(toInClass2);
            //Toast.makeText(this, "Invalid Inputs", Toast.LENGTH_LONG).show();
        }

    }
}