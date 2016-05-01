package com.example.ankush.hyqvia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ankush on 4/30/16.
 */
public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        TextView forum = (TextView) findViewById(R.id.forumText);
        SpannableString content = new SpannableString("Forum");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        forum.setText(content);

        TextView chat = (TextView) findViewById(R.id.chatText);
        content = new SpannableString("Chat");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        chat.setText(content);

        TextView info = (TextView) findViewById(R.id.infoText);
        content = new SpannableString("Info");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        info.setText(content);

        TextView story = (TextView) findViewById(R.id.storyText);
        content = new SpannableString("Story");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        story.setText(content);

        TextView profile = (TextView) findViewById(R.id.profileText);
        content = new SpannableString("Profile");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        profile.setText(content);
    }

    public void forum (View view) {
//        Intent intent = new Intent(Home.this, Forum.class);
//        startActivity(intent);
    }

    public void chat (View view) {
        Intent intent = new Intent(Home.this, Messages.class);
        startActivity(intent);
    }

    public void info (View view) {

    }

    public void story (View view) {

    }

    public void profile (View view) {
        Intent intent = new Intent(Home.this, Profile.class);
        startActivity(intent);
    }

    public void ambassador (View view) {

    }
}