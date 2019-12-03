package com.example.wander;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ObjectiveItemAdapter extends ArrayAdapter<ObjectiveItem> {

    private int resource;

    public ObjectiveItemAdapter(Context ctx, int res, List<ObjectiveItem> items)
    {
        super(ctx, res, items);
        resource = res;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout objectiveView;
        ObjectiveItem ob = getItem(position);

        if (convertView == null) {
            objectiveView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource, objectiveView, true);
        } else {
            objectiveView = (LinearLayout) convertView;
        }

        TextView foundView = (TextView) objectiveView.findViewById(R.id.found_view);
        ImageView imgView = (ImageView) objectiveView.findViewById(R.id.objective_image);

        foundView.setText(ob.getFound() ? "Found" : "Not Found");
        imgView.setImageResource(ob.getImage());

        return objectiveView;
    }


}
