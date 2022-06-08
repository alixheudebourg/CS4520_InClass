package com.example.cs4520_inclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InClass07 extends AppCompatActivity implements NotesFragment.IbuttonActions {

    private TextView title;
    private Button button;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_class_07);

        title = findViewById(R.id.ic7_home_title);
        button = findViewById(R.id.ic7_home_button);

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Notes")
                .add(R.id.ic7_home_fragContainer, new NotesFragment())
                .commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfile();
            }
        });
    }

    public void goToProfile() {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Profile")
                .replace(R.id.ic7_home_fragContainer, new ProfileFragment())
                .commit();

        title.setText(R.string.ic7_profile);
        button.setText(R.string.ic7_notes);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNotes();
            }
        });
    }

    public void goToNotes() {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Notes")
                .replace(R.id.ic7_home_fragContainer, new NotesFragment())
                .commit();

        title.setText(R.string.ic7_notes_title);
        button.setText(R.string.ic7_profile);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfile();
            }
        });
    }

    public void logout() {
        Intent toAccount = new Intent(InClass07.this, LoginActivity.class);
        startActivity(toAccount);
        Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addButtonClicked(Note note) {


    }

    @Override
    public void deleteButtonClicked(Note note) {

    }
}