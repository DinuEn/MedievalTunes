package com.example.medievaltunes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    private ResultsData data;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        data = ResultsData.getInstance();
        TextView usernameTextView = (TextView) findViewById(R.id.username);
        usernameTextView.setText(data.getUsername());

        TextView scoreTextView = (TextView) findViewById(R.id.score);
        scoreTextView.setText("You got " + data.getScore() + "/" + data.getNumberOfQuestions() + " answers right");

    }

    public void tryAgain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
