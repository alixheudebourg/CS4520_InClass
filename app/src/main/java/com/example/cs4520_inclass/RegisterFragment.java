package com.example.cs4520_inclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    private EditText inputName, inputEmail, inputPassword;
    private Button register, login;


    public RegisterFragment() {
        // Required empty public constructor
    }


    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_ic7_register, container, false);

        inputName = rootview.findViewById(R.id.ic7_reg_name);
        inputEmail = rootview.findViewById(R.id.ic7_reg_email);
        inputPassword = rootview.findViewById(R.id.ic7_reg_password);

        register = rootview.findViewById(R.id.ic7_reg_button);
        login = rootview.findViewById(R.id.ic7_reg2login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivity)getActivity()).toLoginFragment();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivity)getActivity()).registerAndLogin();
            }
        });

        return rootview;
    }
}