package com.example.cs4520_inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity implements View.OnClickListener {

    Mood currentMood;
    ImageButton selectAvatar;
    Button submit;
    SeekBar moodSlider;
    ImageView moodImage;
    RadioGroup radioGroup;

    public int getMoodImage() {
        return this.currentMood.getEmoji();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        selectAvatar = findViewById(R.id.imageButton_selectAvatar);
        submit = findViewById(R.id.button_submit);
        moodImage = findViewById(R.id.imageView_moodDisplay);
        radioGroup = findViewById(R.id.radioGroup);
        currentMood = angry;

        selectAvatar.setOnClickListener(this);
        submit.setOnClickListener(this);

        moodSlider = findViewById(R.id.seekBar_mood);
        moodSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress<25) {
                    currentMood = angry;
                }

                else if (progress<50) {
                    currentMood = sad;
                }

                else if (progress<75) {
                    currentMood = happy;
                }

                else {
                    currentMood = awesome;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        if(getIntent()!= null && getIntent().getExtras() != null) {

            String name = getIntent().getStringExtra("Avatar");
            // change profile pic

        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.imageButton_selectAvatar) {
            Intent toSelectAvatar = new Intent("com.example.cs4520_inclass.intent.action.VIEW");
            startActivity(toSelectAvatar);
        }

        else if (v.getId() == R.id.button_submit) {
            Intent toDisplayActivity = new Intent(EditProfile.this, DisplayProfile.class);
            startActivity(toDisplayActivity);
            // get the software choice by using radioGroup.getCheckedRadioButtonId()
            // Toast.makeText(this, radioGroup.getCheckedRadioButtonId(), Toast.LENGTH_LONG).show();
        }

    }

    public void setMoodImage(){
        moodImage.setImageResource(this.currentMood.getEmoji());
    }

    Mood angry = new Mood(R.drawable.angry, "Angry");
    Mood sad = new Mood(R.drawable.sad, "Sad");
    Mood happy = new Mood(R.drawable.happy, "Happy");
    Mood awesome = new Mood(R.drawable.awesome, "Awesome");
}