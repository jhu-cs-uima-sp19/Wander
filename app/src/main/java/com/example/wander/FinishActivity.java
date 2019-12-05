package com.example.wander;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        final SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("gameState", Context.MODE_PRIVATE);
        int possible = sharedPref.getInt("possiblePoints", 0);
        int total = sharedPref.getInt("totalPoints", 0);
        TextView score = (TextView) findViewById(R.id.scoreText);
        score.setText(possible + " / " + total);

        final Button newGame = findViewById(R.id.restart);
        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FinishActivity.this, ContinueActivity.class);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("newGame", true);
                editor.commit();
                startActivity(intent);
            }
        });
    }
}
