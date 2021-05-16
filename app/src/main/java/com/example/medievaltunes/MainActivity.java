package com.example.medievaltunes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void incepe(View view) {
        EditText usernameEdittext = (EditText) findViewById(R.id.player_name);
        String Username = usernameEdittext.getText().toString();
        if(Username.isEmpty()){
            Toast.makeText(this, "Nume neintrodus", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, EcranIntrebare.class);
            startActivity(intent);
            finish();
        }
    }
}