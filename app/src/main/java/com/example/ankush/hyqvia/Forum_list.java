package com.example.ankush.hyqvia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by varungove on 5/1/16.
 */
public class Forum_list extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_list);

        LinearLayout myLayout = (LinearLayout)findViewById(R.id.forum_container);
        View hiddenInfo = getLayoutInflater().inflate(R.layout.forum_thread, myLayout, false);
        myLayout.addView(hiddenInfo);
        hiddenInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Forum_list.this, Forum_thread.class);
        startActivity(intent);
    }

    public void newThread (View view) {
        Intent intent = new Intent(Forum_list.this, New_thread.class);
        startActivity(intent);
    }
}
