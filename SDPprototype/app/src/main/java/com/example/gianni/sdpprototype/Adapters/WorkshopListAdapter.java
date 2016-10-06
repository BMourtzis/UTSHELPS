package com.example.gianni.sdpprototype.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gianni.sdpprototype.Models.Workshop;
import com.example.gianni.sdpprototype.R;

import java.util.ArrayList;

/**
 * Created by Vasil on 28/9/2016.
 */
public class WorkshopListAdapter extends ArrayAdapter<Workshop> {

    private ArrayList<Workshop> workshops;

    public WorkshopListAdapter(Context context, int textViewResourceId, ArrayList<Workshop> items)
    {
        super(context, textViewResourceId, items);
        this.workshops = items;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        if(v == null)
        {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.workshop_set_item_layout, null);
        }

        Workshop r = workshops.get(position);
        TextView nameText = (TextView) v.findViewById(R.id.workshop_set_name);
        nameText.setText(r.getTopic());
        return v;
    }
}
