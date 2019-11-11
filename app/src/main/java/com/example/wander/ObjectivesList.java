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

        ObjectiveItem first = new ObjectiveItem("39.331089, -76.619615", "-1", false, "bluejaystatue");
        objectiveItems.add(0, first);
        ObjectiveItem second = new ObjectiveItem("39.328436, -76.619415", "-1", false, "brody");
        objectiveItems.add(1, second);
        ObjectiveItem third = new ObjectiveItem("39.332122, -76.621277", "-1", false, "athleticcenter");
        objectiveItems.add(2, third);
        ObjectiveItem fourth = new ObjectiveItem("39.328930, -76.617253", "-1", false, "charmar");
        objectiveItems.add(3, fourth);
        ObjectiveItem fifth = new ObjectiveItem("39.329096, -76.618497", "-1", false, "beach");
        objectiveItems.add(4, fifth);


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
