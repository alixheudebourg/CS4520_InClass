package com.example.cs4520_inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic7_login);

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Login")
                .add(R.id.ic7_log_reg_fragment, new LoginFragment())
                .commit();
    }

    public void createAccount() {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Register")
                .replace(R.id.ic06_fragmentContainer, new RegisterFragment())
                .commit();
    }
}