package com.example.wander;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ObjectivesListFragment extends Fragment {
    private ListView objectivesList;
    private ObjectiveItemAdapter aa;

    static ArrayList<ObjectiveItem> objectiveItems = new ArrayList<ObjectiveItem>();;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_objectives, container, false);
        //setContentView(R.layout.activity_objectives);

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


        objectivesList = rootView.findViewById(R.id.objectivelist);
        // make array adapter to bind arraylist to listview with new custom item layout
        aa = new ObjectiveItemAdapter(getActivity().getApplicationContext(), R.layout.objective_item_layout, objectiveItems);
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
