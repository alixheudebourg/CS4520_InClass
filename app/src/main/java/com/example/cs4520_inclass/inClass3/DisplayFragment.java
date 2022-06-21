package com.example.cs4520_inclass.inClass3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs4520_inclass.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayFragment extends Fragment {

    ImageView avatar, emoji;
    TextView name, email, os, mood;

    User user;

    public DisplayFragment() {
        // Required empty public constructor
    }

    public static DisplayFragment newInstance() {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_ic3_display, container, false);

        user = ((InClass03Activity) getActivity()).getUser();

        emoji = rootview.findViewById(R.id.ic03_moodEmojii);
        avatar = rootview.findViewById(R.id.ic03_finalProfile);
        name = rootview.findViewById(R.id.ic03_nameDisp);
        email = rootview.findViewById(R.id.ic03_emailDisp);
        os = rootview.findViewById(R.id.ic03_OSDisp);
        mood = rootview.findViewById(R.id.ic03_moodDisp);

        name.setText(user.getName());
        email.setText(user.getEmail());

        avatar.setImageResource(user.getAvatar());

        changeMood(user.mood);

        if(user.android){
            os.setText("I use Android!");
        } else {
            os.setText("I use iOS!");
        }





        return rootview;
    }

    private void changeMood(String currentMood) {
        if(currentMood =="Angry"){
            emoji.setImageResource(R.drawable.angry);
        }

        else if(currentMood =="Sad"){
            emoji.setImageResource(R.drawable.sad);
        }

        else if(currentMood =="Happy"){
            emoji.setImageResource(R.drawable.happy);
        }

        else {
            emoji.setImageResource(R.drawable.awesome);
        }

        mood.setText("I am "+currentMood);
    }
}