package com.example.ankush.hyqvia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ankush on 4/30/16.
 */
public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    public void signUp (View view) {
            Intent intent = new Intent(Register.this, Home.class);
            startActivity(intent);
            finish();

    }
}