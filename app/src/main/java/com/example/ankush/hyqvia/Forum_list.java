package com.example.ankush.hyqvia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by varungove on 5/1/16.
 */
public class Forum_list extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_list);
    }

    public void newThread (View view) {
        Intent intent = new Intent(Forum_list.this, New_thread.class);
        startActivity(intent);
    }
}
