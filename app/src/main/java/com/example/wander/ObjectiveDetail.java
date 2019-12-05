package com.example.wander;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ObjectiveDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objective_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView location_image = (ImageView) findViewById(R.id.where_image);
        TextView location_name = (TextView) findViewById(R.id.where_text);
        TextView location_desc = (TextView) findViewById(R.id.desc_text);
        TextView date_detail = (TextView) findViewById(R.id.when_text);

        Bundle extras = getIntent().getExtras();
        final int image = extras.getInt("image");
        final String location = extras.getString("name");
        final double lat = extras.getDouble("lat");
        final double lng = extras.getDouble("long");
        String description = extras.getString("description");
        String date = extras.getString("when");

        location_name.setText(location);
        location_desc.setText(description);
        date_detail.setText(date);
        location_image.setImageResource(image);

        final Button setCurrent = findViewById(R.id.set_current);
        setCurrent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("gameState", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("currImage", image);
                editor.putString("currName", location);
                editor.putFloat("currLat", (float) lat);
                editor.putFloat("currLong", (float) lng);
                editor.commit();
                onBackPressed();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
