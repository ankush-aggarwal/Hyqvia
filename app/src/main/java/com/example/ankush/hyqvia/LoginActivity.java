package com.example.ankush.hyqvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signIn (View view) {
        Intent intent = new Intent(LoginActivity.this, Home.class);
        startActivity(intent);
        finish();
    }

    public void register (View view) {
        Intent intent = new Intent(LoginActivity.this, Register.class);
        startActivity(intent);
    }
}