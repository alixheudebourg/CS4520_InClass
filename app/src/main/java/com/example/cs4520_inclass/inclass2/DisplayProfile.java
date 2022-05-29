package com.example.cs4520_inclass.inclass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cs4520_inclass.R;

public class DisplayProfile extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);
    }

    @Override
    public void onClick(View v) {
         Intent toEditProfile = new Intent(DisplayProfile.this, EditProfile.class);
         startActivity(toEditProfile);
         //Toast.makeText(this, "Invalid Inputs", Toast.LENGTH_LONG).show();

    }
}