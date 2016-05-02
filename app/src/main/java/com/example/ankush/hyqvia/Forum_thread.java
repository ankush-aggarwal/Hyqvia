package com.example.ankush.hyqvia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by ankush on 5/2/16.
 */
public class Forum_thread extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread);

        LinearLayout myLayout = (LinearLayout)findViewById(R.id.thread_container);
        View hiddenInfo = getLayoutInflater().inflate(R.layout.forum_thread_entry, myLayout, false);
        myLayout.addView(hiddenInfo);

        hiddenInfo = getLayoutInflater().inflate(R.layout.add_thread_entry, myLayout, false);
        myLayout.addView(hiddenInfo);
    }
}

