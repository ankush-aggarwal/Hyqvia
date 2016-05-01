package com.example.ankush.hyqvia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ankush on 5/1/16.
 */
public class Messages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages);

        LinearLayout myLayout = (LinearLayout)findViewById(R.id.container);
        View hiddenInfo = getLayoutInflater().inflate(R.layout.messages_user_row, myLayout, false);
        myLayout.addView(hiddenInfo);

    }
}
