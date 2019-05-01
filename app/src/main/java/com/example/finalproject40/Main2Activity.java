package com.example.finalproject40;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class Main2Activity extends AppCompatActivity {
    private String input;
    private String category;
    private String diff;
    private String question;
    private String answer;
    private String wrong;
    private String[] inc;
    private MainActivity ma;

    public void setMA(MainActivity m) {
        ma = m;
    }

    public void getAPI() {
        new APICaller().execute();
    }
    public String getDiff() {
        return diff;
    }
    public String getCat() {
        return category;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public String getChoice1() {
        return inc[0];
    }
    public String getChoice2() {
        return inc[1];
    }
    public String getChoice3() {
        return inc[2];
    }
    public String getChoice4() {
        return inc[3];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    class APICaller extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected void onPreExecute() {
        }

        protected String doInBackground(Void... urls) {

            try {

                URL url = new URL("https://opentdb.com/api.php?amount=1");
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    input = stringBuilder.toString();
                    return input;
                }
                finally{
                    conn.disconnect();
                }
            }
            catch(Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            int cateIndex = input.indexOf("category");
            int diffIndex = input.indexOf("difficulty");
            int queIndex = input.indexOf("question");
            int ansIndex = input.indexOf("correct_answer");
            int wrongIndex = input.indexOf("incorrect_answers");
            int endIndex = input.indexOf("]}]}");

            category = input.substring(cateIndex + 11, diffIndex - 21); //first index = cateindex + whatever is there + 1, diffindex - 3
            diff = input.substring(diffIndex + 13, queIndex - 3);
            question = input.substring(queIndex + 11, ansIndex - 3);
            answer = input.substring(ansIndex + 16, wrongIndex - 2);
            wrong = input.substring(wrongIndex + 20, endIndex);

            int counter = 0;
            if (inc == null) {
                inc = new String[3];
            }

            for (String a : wrong.split(",")) {
                inc[counter] = a;
                counter++;
            }

            ma.updateQuestion();
        }
    }

}
