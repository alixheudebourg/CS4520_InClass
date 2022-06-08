package com.example.cs4520_inclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LifecycleOwner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic7_login);

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Login")
                .add(R.id.ic7_log_reg_fragment, new LoginFragment())
                .commit();

        setTitle(R.string.ic7_app_name);
    }

    public void toRegisterFragment() {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Register")
                .replace(R.id.ic7_log_reg_fragment, new RegisterFragment())
                .commit();
    }

    public void toLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("Login")
                .replace(R.id.ic7_log_reg_fragment, new LoginFragment())
                .commit();
    }

    public void login() {
        Intent toAccount = new Intent(LoginActivity.this, InClass07.class);
        startActivity(toAccount);
    }

    public void registerAndLogin() {
        Intent toAccount = new Intent(LoginActivity.this, InClass07.class);
        startActivity(toAccount);
        Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
    }
}