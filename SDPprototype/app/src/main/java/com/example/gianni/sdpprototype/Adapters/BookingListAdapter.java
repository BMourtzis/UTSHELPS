package com.example.gianni.sdpprototype.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gianni.sdpprototype.Models.Booking;
import com.example.gianni.sdpprototype.Models.WorkshopSet;
import com.example.gianni.sdpprototype.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Vasil on 28/9/2016.
 */

public class BookingListAdapter extends ArrayAdapter<Booking> {

    private ArrayList<Booking> bookings;

    public BookingListAdapter(Context context, int textViewResourceId, ArrayList<Booking> items)
    {
        super(context, textViewResourceId, items);
        this.bookings = items;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        if(v == null)
        {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.booking_list_item, null);
        }

        Booking r = bookings.get(position);
        TextView topicText = (TextView) v.findViewById(R.id.booking_topic);
        topicText.setText(r.getTopic());
        TextView startingText = (TextView) v.findViewById(R.id.booking_starting);
        startingText.setText(r.getStarting());
        return v;
    }
}
