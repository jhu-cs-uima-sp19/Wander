package com.example.wander;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ObjectivesList extends AppCompatActivity {
    private ListView objectivesList;
    private ObjectiveItemAdapter aa;

    static ArrayList<ObjectiveItem> objectiveItems = new ArrayList<ObjectiveItem>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectives);

        objectivesList = (ListView) findViewById(R.id.objectivelist);
        // make array adapter to bind arraylist to listview with new custom item layout
        aa = new ObjectiveItemAdapter(this, R.layout.objective_item_layout, objectiveItems);
        objectivesList.setAdapter(aa);

        registerForContextMenu(objectivesList);

        aa.notifyDataSetChanged();  // to refresh items in the list

        // program a short click on the list item
        objectivesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjectiveItem objective = aa.getItem(position);

                Intent intent = new Intent(ObjectivesList.this, ObjectiveDetail.class);
                intent.putExtra("location", objective.getLocation());
                intent.putExtra("when", objective.getWhen());
                intent.putExtra("found", objective.getFound());

                startActivity(intent);
            }
        });
    }
}
