package com.example.cs4520_inclass.inclass2;

import android.media.Image;

public class Mood {
    private int emoji;
    private String name;

    public Mood(int emoji, String name){
        this.emoji = emoji;
        this.name = name;
    }

    public void setEmoji(int newEmoji) {
        this.emoji = newEmoji;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getEmoji() {
        return this.emoji;
    }

    public String getName() {
        return this.name;
    }

    public String getMoodMessage(){
        return "I am "+ this.name + "!";
    }

    public String getCurrentMoodMessage(){
        return "Your current mood: "+ this.name;
    }

}

//Mood happy = new Mood(R.drawable.happy, "Happy");
//Mood angry = new Mood(R.drawable.angry, "Angry");
//Mood sad = new Mood(R.drawable.sad, "Sad");
//Mood awesome = new Mood(R.drawable.awesome, "Awesome");



