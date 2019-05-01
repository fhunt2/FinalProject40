package com.example.finalproject40;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {



    private TextView questionView;
    private TextView scoreView;
    private Button bChoice1; Button bChoice2; Button bChoice3; Button bChoice4;
    private String answer;
    private int qNumber = 0;
    private int score = 0;

    private Main2Activity input = new Main2Activity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreView = (TextView)findViewById(R.id.score);
        questionView = (TextView)findViewById(R.id.question);
        bChoice1 = (Button)findViewById(R.id.choice1);
        bChoice2 = (Button)findViewById(R.id.choice2);
        bChoice3 = (Button)findViewById(R.id.choice3);
        bChoice4 = (Button)findViewById(R.id.choice4);

        input.setMA(this);
        input.getAPI();
//        updateQuestion();

        bChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bChoice1.getText().equals(answer)) {
                    addScore(score);
                    //updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                try {
                    Thread.sleep(1000);
                    input.getAPI();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        bChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bChoice2.getText().equals(answer)) {
                    addScore(score);
                    //updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                try {
                    Thread.sleep(1000);
                    input.getAPI();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        bChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bChoice3.getText().equals(answer)) {
                    addScore(score);
                    //updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                try {
                    Thread.sleep(1000);
                    input.getAPI();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        bChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bChoice4.getText().equals(answer)) {
                    addScore(score);
                    //updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                try {
                    Thread.sleep(1000);
                    input.getAPI();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void addScore(int current) {
        score += 1;
        scoreView.setText("" + score);
    }

    public void updateQuestion() {
        questionView.setText(input.getQuestion());
        bChoice1.setText(input.getChoice1());
        bChoice2.setText(input.getChoice2());
        bChoice3.setText(input.getChoice3());
        bChoice4.setText(input.getAnswer());
        answer = input.getAnswer();
    }

}
