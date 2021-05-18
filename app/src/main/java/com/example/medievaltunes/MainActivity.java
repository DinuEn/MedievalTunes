package com.example.medievaltunes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private ResultsData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = ResultsData.getInstance();
    }


    public void start(View view) {
        EditText usernameEdittext = (EditText) findViewById(R.id.player_name);
        String Username = usernameEdittext.getText().toString();

        if(Username.isEmpty()){ //check if the username is empty and return a message if so
            Toast.makeText(this, "Blank username", Toast.LENGTH_SHORT).show();
        }
        else{//if username is not empty start the question activity
            data.setUsername(Username);
            Intent intent = new Intent(this, QuestionActivity.class);
            startActivity(intent);
            finish();
        }
    }
}