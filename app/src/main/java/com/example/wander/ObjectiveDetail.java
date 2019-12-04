package com.example.wander;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
        int image = extras.getInt("image");
        String location = extras.getString("name");
        String description = extras.getString("description");
        String date = extras.getString("when");

        location_name.setText(location);
        location_desc.setText(description);
        date_detail.setText(date);
        location_image.setImageResource(image);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void setCurrent(View v) {
        getIntent().putExtra("change", true);
        finish();
    }

}
