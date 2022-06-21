package com.example.cs4520_inclass.inClass3;


import com.example.cs4520_inclass.R;

import java.net.URI;

public class User {

    String name, email, mood;
    int avatar;
    Boolean android;

    public User() {
        this.name = "";
        this.email = "";
        this.mood = "Angry";
        this.avatar = R.drawable.select_avatar;
        this.android = true;

    }

    public User(String name, String email, Boolean android,
                int avatar, String mood) {
        this.name = name;
        this.email = email;
        this.android = android;
        this.avatar = avatar;
        this.mood = mood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAndroid() {
        return android;
    }

    public void setAndroid(Boolean android) {
        this.android = android;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
