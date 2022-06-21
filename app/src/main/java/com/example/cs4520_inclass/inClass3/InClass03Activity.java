package com.example.cs4520_inclass.inClass3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cs4520_inclass.R;

public class InClass03Activity extends AppCompatActivity {

    public int avatar_id =0 ;
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_class03);

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Edit Profile")
                .add(R.id.ic03_fragmentContainer, new EditProfileFragment())
                .commit();

        setTitle("Edit Profile");
    }

    public void toSelectAvatar(){
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Select Avatar")
                .replace(R.id.ic03_fragmentContainer, new SelectAvatarFragment())
                .commit();

        setTitle("Select Avatar");
    }

    public void toEditActivity(int drawable){
         avatar_id = drawable;

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Edit Profile")
                .replace(R.id.ic03_fragmentContainer, new EditProfileFragment())
                .commit();

        setTitle("Edit Profile");
    }

    public void toDisplayAvatar(User newUser){

        user = newUser;

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Display")
                .replace(R.id.ic03_fragmentContainer, new DisplayFragment())
                .commit();

        setTitle("Display");
    }

    public int getAvatar_id(){
        return avatar_id;
    }

    public User getUser(){
        return user;
    }

    public void makeToast(String message){
        Toast.makeText(this, "Fill out all fields", Toast.LENGTH_LONG).show();
    }
}