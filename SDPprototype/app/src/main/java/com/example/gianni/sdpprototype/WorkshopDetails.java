package com.example.gianni.sdpprototype;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Gianni on 7/09/2016.
 */
public class WorkshopDetails extends Fragment{

    View workshopDetailsView;
    Button button;
    Button button2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        workshopDetailsView = inflater.inflate(R.layout.workshop_details, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_workshop_details);

        button = (Button) workshopDetailsView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(workshopDetailsView, "Your booking has been made", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                button2.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
            }
        });

        button2 = (Button) workshopDetailsView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(workshopDetailsView, "Your booking has been cancelled", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                button2.setVisibility(View.INVISIBLE);
                button.setVisibility(View.VISIBLE);
            }
        });
        return workshopDetailsView;
    }
}
