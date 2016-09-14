package com.example.gianni.sdpprototype;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Gianni on 7/09/2016.
 */
public class UpcomingSessions extends Fragment {

    View upcomingSessions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        upcomingSessions = inflater.inflate(R.layout.upcoming_sessions, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_upcoming_sessions);

        Button button = (Button) upcomingSessions.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new WorkshopDetails();

                FragmentManager fragmentManager = getFragmentManager();

                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

        return upcomingSessions;
    }

}

