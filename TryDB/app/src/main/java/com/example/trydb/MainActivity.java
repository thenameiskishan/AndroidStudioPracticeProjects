package com.example.trydb;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private static final String PHP_URL = "http://localhost:3306/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new PostToPHP().execute("String1", "String2");
    }

    private class PostToPHP extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(PHP_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                String postData = URLEncoder.encode("param1", "UTF-8") + "=" + URLEncoder.encode(strings[0], "UTF-8");
                postData += "&" + URLEncoder.encode("param2", "UTF-8") + "=" + URLEncoder.encode(strings[1], "UTF-8");
                os.write(postData.getBytes());

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder result = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                reader.close();
                os.close();
                return result.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Here you can handle the output, update UI, etc.
            // For example: textView.setText(result);
        }
    }
}
