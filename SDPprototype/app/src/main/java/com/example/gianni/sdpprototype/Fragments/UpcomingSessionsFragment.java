package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gianni.sdpprototype.Adapters.WorkshopSetListAdapter;
import com.example.gianni.sdpprototype.MainActivity;
import com.example.gianni.sdpprototype.Models.WorkshopSet;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.StudentResponse;
import com.example.gianni.sdpprototype.Responses.WorkshopSetResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gianni on 7/09/2016.
 */
public class UpcomingSessionsFragment extends ListFragment {

    View upcomingSessions;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        RestClient client = new RestClient();
        Call<WorkshopSetResponse> call = client.getHelpsService().getWorkshopSets(true);

        call.enqueue(new Callback<WorkshopSetResponse>() {
            @Override
            public void onResponse(Call<WorkshopSetResponse> call, Response<WorkshopSetResponse> response)
            {
                ArrayList<WorkshopSet> items = new ArrayList<WorkshopSet>(response.body().getResults());
                WorkshopSetListAdapter adapter = new WorkshopSetListAdapter(getActivity(), R.layout.workshop_set_item_layout, items);
                setListAdapter(adapter);
            }

            @Override
            public void onFailure(Call<WorkshopSetResponse> call, Throwable t)
            {
                int i = 0;
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        upcomingSessions = inflater.inflate(R.layout.upcoming_sessions, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_upcoming_sessions);

        return upcomingSessions;
    }
}

