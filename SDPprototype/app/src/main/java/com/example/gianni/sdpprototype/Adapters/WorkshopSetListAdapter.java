package com.example.gianni.sdpprototype.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gianni.sdpprototype.Models.WorkshopSet;
import com.example.gianni.sdpprototype.R;

import java.util.ArrayList;

/**
 * Created by Vasil on 24/9/2016.
 */

public class WorkshopSetListAdapter extends ArrayAdapter<WorkshopSet>
{
    private ArrayList<WorkshopSet> workshopSets;

    public WorkshopSetListAdapter(Context context, int textViewResourceId, ArrayList<WorkshopSet> items)
    {
        super(context, textViewResourceId, items);
        this.workshopSets = items;

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

        WorkshopSet r = workshopSets.get(position);
        TextView nameText = (TextView) v.findViewById(R.id.workshop_set_name);
        nameText.setText(r.getName());
        return v;
    }
}
