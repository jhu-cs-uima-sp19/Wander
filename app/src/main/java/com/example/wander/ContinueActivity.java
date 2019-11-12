package com.example.wander;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContinueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        final Button newGame = findViewById(R.id.new_game);
        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ContinueActivity.this, MainActivity.class);
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("gameState", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("newGame", true);
                editor.commit();
                startActivity(intent);
            }
        });

        final Button continueGame = findViewById(R.id.continue_game);
        continueGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ContinueActivity.this, MainActivity.class);
                intent.putExtra("startOver", false);
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("gameState", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("newGame", false);
                editor.commit();
                startActivity(intent);
            }
        });
    }
}
