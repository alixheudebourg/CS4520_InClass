package com.example.cs4520_inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cs4520_inclass.inclass2.EditProfile;

public class InClass05 extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;
    ImageView display;
    ImageButton buttonPrevious, buttonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclass05);

        editText = findViewById(R.id.editText_searchKeyword);
        button = findViewById(R.id.button_searchKeyword);
        display = findViewById(R.id.imageView_displayKeyword);
        buttonPrevious = findViewById(R.id.imageButton_previous);
        buttonNext = findViewById(R.id.imageButton_next);

        button.setOnClickListener(this);
        buttonPrevious.setOnClickListener(this);
        buttonNext.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_searchKeyword) {
            //Intent toInClass1 = new Intent(MainActivity.this, BMI_Calculator.class);
            //startActivity(toInClass1);
            String input = editText.getText().toString();
            Toast.makeText(this, input, Toast.LENGTH_LONG).show();
        }

        if (v.getId() == R.id.imageButton_previous) {

            Toast.makeText(this, "ye", Toast.LENGTH_LONG).show();
        }

        if (v.getId() == R.id.imageButton_next) {

            Toast.makeText(this, "yah", Toast.LENGTH_LONG).show();
        }
    }
}