package com.example.ankush.hyqvia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankush on 5/2/16.
 */
public class Forum_thread extends AppCompatActivity {

    JSONObject jsonObject;

    JSONParser jsonParser = new JSONParser();
    private ProgressDialog pDialog;

    private static final String GET_COMMENTS_URL = "http://web.engr.illinois.edu/~goverdh2/returnComment.php";
    private static final String ADD_COMMENT_URL = "http://web.engr.illinois.edu/~goverdh2/addComment.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String username, comment, tid, subject, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread);

        tid = getIntent().getExtras().getString("tid");
        subject = getIntent().getExtras().getString("subject");
        data = getIntent().getExtras().getString("data");

        TextView thread_subject = (TextView) findViewById(R.id.thread_subject);
        thread_subject.setText(subject);

        TextView thread_data = (TextView) findViewById(R.id.thread_data);
        thread_data.setText(data);

        new getComments().execute();

    }

    class getComments extends AsyncTask<String, String, String> {

        //three methods get called, first preExecture, then do in background, and once do
        //in back ground is completed, the onPost execture method will be called.

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Forum_thread.this);
            pDialog.setMessage("Getting thread...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... args) {

            // TODO Auto-generated method stub
            // Check for success tag
            int success;

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("tid", tid));

            // getting product details by making HTTP request
            jsonObject = jsonParser.makeHttpRequest(GET_COMMENTS_URL, "POST", params);

            return null;

        }

        protected void onPostExecute(String string) {

            // dismiss the dialog once product deleted
            pDialog.dismiss();
            populateThread();
        }

    }

    private void populateThread() {

        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        LinearLayout myLayout = (LinearLayout)findViewById(R.id.thread_container);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject comment_obj = null;
            try {
                comment_obj = jsonArray.getJSONObject(i);

                View hiddenInfo = getLayoutInflater().inflate(R.layout.forum_thread_entry, myLayout, false);
                myLayout.addView(hiddenInfo);

                TextView comment = (TextView) hiddenInfo.findViewById(R.id.comment);
                comment.setText(comment_obj.getString("data"));

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        View hiddenInfo = getLayoutInflater().inflate(R.layout.add_thread_entry, myLayout, false);
        myLayout.addView(hiddenInfo);

        final EditText et_comment = (EditText) hiddenInfo.findViewById(R.id.comment);
        Button add = (Button) hiddenInfo.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                comment = et_comment.getText().toString();
                new addComment().execute();
            }
        });
    }

    class addComment extends AsyncTask<String, String, String> {

        //three methods get called, first preExecture, then do in background, and once do
        //in back ground is completed, the onPost execture method will be called.

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Forum_thread.this);
            pDialog.setMessage("Posting comment...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... args) {

            // TODO Auto-generated method stub
            // Check for success tag
            int success;

            try {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Forum_thread.this);
                username = sp.getString("username", null);

                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("tid", tid));
                params.add(new BasicNameValuePair("data", comment));
                params.add(new BasicNameValuePair("user", username));

                // getting product details by making HTTP request
                JSONObject json = jsonParser.makeHttpRequest(ADD_COMMENT_URL, "POST", params);

                // json success tag
                success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    return json.getString(TAG_MESSAGE);
                } else {
                    return json.getString(TAG_MESSAGE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        protected void onPostExecute(String string) {

            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (string != null){
                Toast.makeText(Forum_thread.this, string, Toast.LENGTH_LONG).show();
            }
        }

    }

}

