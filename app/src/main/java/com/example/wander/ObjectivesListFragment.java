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
import java.util.Arrays;
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
            ObjectiveItem obj1 = new ObjectiveItem("Blue Jay Statue", R.drawable.bluejaystatue, 20, 39.331089, -76.619615);
            ObjectiveItem obj2 = new ObjectiveItem("Brody Learning Commons", R.drawable.brody, 10, 39.328436, -76.619415);
            ObjectiveItem obj3 = new ObjectiveItem("O'Connor Rec Center", R.drawable.athleticcenter, 30, 39.332122, -76.621277);
            ObjectiveItem obj4 = new ObjectiveItem("Charles Street Market", R.drawable.charmar, 20, 39.328930, -76.617253);
            ObjectiveItem obj5 = new ObjectiveItem("The Beach", R.drawable.beach, 10, 39.329096, -76.618497);
            ObjectiveItem obj6 = new ObjectiveItem("Malone Hall", R.drawable.malonehall, 40, 39.326191, -76.620853);
            ObjectiveItem obj7 = new ObjectiveItem("Homewood Museum", R.drawable.homewoodmuseum, 20, 39.329722, -76.618962);
            ObjectiveItem obj8 = new ObjectiveItem("University Market", R.drawable.unimini, 20, 39.327828, -76.615817);
            ObjectiveItem obj9 = new ObjectiveItem("Gilman Hall", R.drawable.gilmanhall, 20, 39.328982, -76.621362);

            obj1.setDescription("Campus icon, gets spray painted all the time.");
            obj2.setDescription("A place of eternal student suffering.");
            obj3.setDescription("Get jacked.");
            obj4.setDescription("Dump your dining dollars here.");
            obj5.setDescription("Names can be deceiving.");
            obj6.setDescription("Nicest building on campus.");
            obj7.setDescription("We have a museum on campus?");
            obj8.setDescription("Nice.");
            obj9.setDescription("Featured in every Hopkins photo ever.");

            objectiveItems = new ArrayList<ObjectiveItem>(Arrays.asList(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9));
            Collections.shuffle(objectiveItems);
            displayedObjectiveItems = new ArrayList<ObjectiveItem>();
            for (int i = 0; i < 6; i++) {
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
                intent.putExtra("name", objective.getName());
                intent.putExtra("image", objective.getImage());
                intent.putExtra("description", objective.getDescription());
                intent.putExtra("points", objective.getPoints());
                intent.putExtra("lat", objective.getLat());
                intent.putExtra("long", objective.getLong());
                intent.putExtra("found", objective.getFound());
                intent.putExtra("when", objective.getWhen());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
