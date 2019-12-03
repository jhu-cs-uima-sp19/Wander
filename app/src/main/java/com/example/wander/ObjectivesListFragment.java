package com.example.wander;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectivesListFragment extends Fragment {
    private GridView objectivesList;
    private ObjectiveItemAdapter aa;

    static ArrayList<ObjectiveItem> objectiveItems = new ArrayList<ObjectiveItem>();
    static ArrayList<ObjectiveItem> displayedObjectiveItems = new ArrayList<ObjectiveItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_objectives, container, false);
        //setContentView(R.layout.activity_objectives);

        SharedPreferences sharedPref = this.getActivity().getApplicationContext().getSharedPreferences("gameState", Context.MODE_PRIVATE);
        boolean newGame = sharedPref.getBoolean("newGame", true);

        Gson gson = new Gson();

        if (newGame) {
            ObjectiveItem first = new ObjectiveItem("39.331089, -76.619615", "-1", false, R.drawable.bluejaystatue);
            objectiveItems.add(0, first);
            ObjectiveItem second = new ObjectiveItem("39.328436, -76.619415", "-1", false, R.drawable.brody);
            objectiveItems.add(1, second);
            ObjectiveItem third = new ObjectiveItem("39.332122, -76.621277", "-1", false, R.drawable.athleticcenter);
            objectiveItems.add(2, third);
            ObjectiveItem fourth = new ObjectiveItem("39.328930, -76.617253", "-1", false, R.drawable.charmar);
            objectiveItems.add(3, fourth);
            ObjectiveItem fifth = new ObjectiveItem("39.329096, -76.618497", "-1", false, R.drawable.beach);
            objectiveItems.add(4, fifth);
            ObjectiveItem sixth = new ObjectiveItem("39.326191 -76.620853", "-1", false, R.drawable.malonehall);
            objectiveItems.add(5, sixth);
            ObjectiveItem seventh = new ObjectiveItem("39.329722, -76.618962", "-1", false, R.drawable.homewoodmuseum);
            objectiveItems.add(6, seventh);
            ObjectiveItem eighth = new ObjectiveItem("39.327828, -76.615817", "-1", false, R.drawable.unimini);
            objectiveItems.add(7, eighth);
            ObjectiveItem ninth = new ObjectiveItem("39.328982, -76.621362", "-1", false, R.drawable.gilmanhall);
            objectiveItems.add(8, ninth);

            Collections.shuffle(objectiveItems);
            for (int i = 0; i < 4; i++) {
                displayedObjectiveItems.add(objectiveItems.get(i));
            }

            String json = gson.toJson(displayedObjectiveItems);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("newGame", false);
            editor.putString("objectiveList", json);
            editor.commit();
        }
        else {
            String response = sharedPref.getString("objectiveList", "");
            displayedObjectiveItems = gson.fromJson(response,
                    new TypeToken<List<ObjectiveItem>>(){}.getType());
        }

        objectivesList = rootView.findViewById(R.id.objectivelist);
        // make array adapter to bind arraylist to listview with new custom item layout
        aa = new ObjectiveItemAdapter(getActivity().getApplicationContext(), R.layout.objective_item_layout, displayedObjectiveItems);
        objectivesList.setAdapter(aa);

        registerForContextMenu(objectivesList);

        aa.notifyDataSetChanged();  // to refresh items in the list

        // program a short click on the list item
        objectivesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjectiveItem objective = aa.getItem(position);
                Intent intent = new Intent(getActivity(), ObjectiveDetail.class);
                intent.putExtra("location", objective.getLocation());
                intent.putExtra("when", objective.getWhen());
                intent.putExtra("found", objective.getFound());
                intent.putExtra("image", objective.getImage());
                Log.d("myTag", "HIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
                startActivity(intent);
            }
        });
        return rootView;
    }
}
