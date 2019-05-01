package com.example.finalproject40;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InitialPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_page);
        Intent intent = getIntent();
        findViewById(R.id.start).setOnClickListener(check);
    }

    private View.OnClickListener check = new View.OnClickListener() {
        public void onClick(View v) {
            if (v.getId() == R.id.start) { //start button triggers the app
                startActivity(new Intent(InitialPage.this, MainActivity.class));
            }
        }
    };
}
