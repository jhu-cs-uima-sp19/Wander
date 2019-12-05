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

        final SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("gameState", Context.MODE_PRIVATE);
        final boolean isNewGame = sharedPref.getBoolean("newGame", true);

        final Button newGame = findViewById(R.id.new_game);
        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ContinueActivity.this, MainActivity.class);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("newGame", true);
                editor.putInt("currImage", -1);
                editor.putString("currName", null);
                editor.commit();
                startActivity(intent);
            }
        });

        final Button continueGame = findViewById(R.id.continue_game);
        continueGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!isNewGame) {
                    Intent intent = new Intent(ContinueActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
