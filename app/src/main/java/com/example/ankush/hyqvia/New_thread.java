package com.example.ankush.hyqvia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by varungove on 5/2/16.
 */
public class New_thread extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_thread);

       EditText subject = (EditText)findViewById(R.id.subject);
       EditText details = (EditText)findViewById(R.id.details);

        Button mSubmit = (Button)findViewById(R.id.submit_thread);


    }


    public void submit(View v) {
                new AttemptLogin().execute();

    }

    //AsyncTask is a seperate thread than the thread that runs the GUI
    //Any type of networking should be done with asynctask.
    class AttemptLogin extends AsyncTask<String, String, String> {

        //three methods get called, first preExecture, then do in background, and once do
        //in back ground is completed, the onPost execture method will be called.

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... args) {

            return null;

        }

        protected void onPostExecute(String file_url) {

        }

    }

    JSONParser jsonParser = new JSONParser();

    private static final String LOGIN_URL = "http://web.engr.illinois.edu/~goverdh2/index.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

}
