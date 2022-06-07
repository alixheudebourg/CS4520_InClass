package com.example.cs4520_inclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.os.Bundle;
import android.widget.EditText;

public class InClass07Activity extends AppCompatActivity implements LifecycleOwner  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic7_profile);

    }

}