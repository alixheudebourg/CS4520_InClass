package com.example.cs4520_inclass.inClass3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs4520_inclass.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditProfileFragment extends Fragment {

    EditText name, email;
    ImageButton selectAvatar;
    RadioGroup osSelection;
    SeekBar slider;
    ImageView emoji;
    TextView moodDisp;
    Button submit;
    String currentMood = "Angry";
    boolean android = true;


    public EditProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditProfileFragment newInstance(String param1, String param2) {
        EditProfileFragment fragment = new EditProfileFragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ic3_edit_profile, container, false);



        name = rootView.findViewById(R.id.ic03_nameInput);
        email = rootView.findViewById(R.id.ic03_emailInput);
        selectAvatar = rootView.findViewById(R.id.ic03_chooseAvatar);
        osSelection = rootView.findViewById(R.id.ic3_radioGroup);
        slider = rootView.findViewById(R.id.ic03_seekBar);
        email = rootView.findViewById(R.id.ic03_emailInput);
        submit = rootView.findViewById(R.id.ic03_submit);
        moodDisp = rootView.findViewById(R.id.ic03_moodDisplay);
        emoji = rootView.findViewById(R.id.ic03_moodImage);


        int avatarID = ((InClass03Activity) getActivity()).getAvatar_id();

        if (avatarID != 0) {
            selectAvatar.setImageResource(avatarID);
        }

        selectAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((InClass03Activity) getActivity()).toSelectAvatar();
            }
        });

        osSelection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.ic3_android) {
                    android = true;
                } else {
                    android = false;
                }
            }
        });

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeMood(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(name.getText().toString() != "" || email.getText().toString() != "") {
                    User newUser = new User(name.getText().toString(),
                            email.getText().toString(),
                            android,
                            avatarID,
                            currentMood);
                    ((InClass03Activity) getActivity()).toDisplayAvatar(newUser);
                }

                else {
                    ((InClass03Activity) getActivity()).makeToast("Fill out all fields before submitting.");
                }


            }
        });



        return rootView;
    }

    private void changeMood(int num) {
        if(num == 0 ){
            currentMood = "Angry";
            emoji.setImageResource(R.drawable.angry);
        }

        else if(num == 1){
            currentMood = "Sad";
            emoji.setImageResource(R.drawable.sad);
        }

        else if(num == 2){
            currentMood = "Happy";
            emoji.setImageResource(R.drawable.happy);
        }

        else {
            currentMood = "Awesome";
            emoji.setImageResource(R.drawable.awesome);
        }

        moodDisp.setText(currentMood);
    }

    public boolean checkConditions() {
        return TextUtils.isEmpty(name.getText().toString()) ||
                TextUtils.isEmpty(email.getText().toString());
    }


}