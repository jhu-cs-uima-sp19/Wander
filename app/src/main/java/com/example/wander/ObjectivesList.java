package com.example.wander;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ObjectivesList extends AppCompatActivity {
    private ListView objectivesList;
    private ObjectiveItemAdapter aa;

    static ArrayList<ObjectiveItem> objectiveItems = new ArrayList<ObjectiveItem>();
    static ArrayList<ObjectiveItem> displayedObjectiveItems = new ArrayList<ObjectiveItem>();


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
        ObjectiveItem sixth = new ObjectiveItem("39.326191 -76.620853", "-1", false, "malonehall");
        objectiveItems.add(5, sixth);
        ObjectiveItem seventh = new ObjectiveItem("39.329722, -76.618962", "-1", false, "homewoodmuseum");
        objectiveItems.add(6, seventh);
        ObjectiveItem eighth = new ObjectiveItem("39.327828, -76.615817", "-1", false, "unimini");
        objectiveItems.add(7, eighth);
        ObjectiveItem ninth = new ObjectiveItem("39.328982, -76.621362", "-1", false, "gilmanhall");
        objectiveItems.add(8, ninth);

        Random rand = new Random();
        int temp;
        int[] usedIndices = new int[5];
        boolean used = false;

        for (int i = 0; i < 5; i ++) {
            temp = rand.nextInt(8);
            for (int j = 0; j < 5; j++) {
                if (usedIndices[j] == temp) {
                    used = true;
                }
            }
            if (!used) {
                usedIndices[i] = temp;
            } else {
                i--;
            }
        }

        for (int i = 0; i < 5; i++) {
            displayedObjectiveItems.add(i, objectiveItems.get(usedIndices[i]));
        }


        objectivesList = (ListView) findViewById(R.id.objectivelist);
        // make array adapter to bind arraylist to listview with new custom item layout
        aa = new ObjectiveItemAdapter(this, R.layout.objective_item_layout, displayedObjectiveItems);
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
                intent.putExtra("image", objective.getImage());

                startActivity(intent);
            }
        });
    }
}
