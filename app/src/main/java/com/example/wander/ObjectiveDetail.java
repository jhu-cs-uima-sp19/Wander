package com.example.wander;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
        TextView location_detail = (TextView) findViewById(R.id.where_text);
        TextView date_detail = (TextView) findViewById(R.id.when_text);

        Bundle extras = getIntent().getExtras();
        String image = extras.getString("image");
        String location = extras.getString("location");
        String date = extras.getString("when");

        //location_image.setImage(image);
        location_detail.setText(location);
        date_detail.setText(date);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
