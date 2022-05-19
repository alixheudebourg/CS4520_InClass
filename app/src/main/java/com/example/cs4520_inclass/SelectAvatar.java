package com.example.cs4520_inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SelectAvatar extends AppCompatActivity implements View.OnClickListener {

    ImageButton f1, f2, f3, m1, m2, m3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar);

        f1 = findViewById(R.id.imageButton_f1);
        f2 = findViewById(R.id.imageButton_f2);
        f3 = findViewById(R.id.imageButton_f3);
        m1 = findViewById(R.id.imageButton_m1);
        m2 = findViewById(R.id.imageButton_m2);
        m3 = findViewById(R.id.imageButton_m3);

        f1.setOnClickListener(this);
        f2.setOnClickListener(this);
        f3.setOnClickListener(this);
        m1.setOnClickListener(this);
        m2.setOnClickListener(this);
        m3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent toSelectAvatar = new Intent(SelectAvatar.this, EditProfile.class);
        toSelectAvatar.putExtra("Avatar", "noar");
        startActivity(toSelectAvatar);
    }
}