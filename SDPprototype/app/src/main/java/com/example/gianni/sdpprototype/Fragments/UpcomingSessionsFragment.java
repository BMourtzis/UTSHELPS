package com.example.gianni.sdpprototype.Fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gianni.sdpprototype.Adapters.WorkshopSetListAdapter;
import com.example.gianni.sdpprototype.FragmentCallback;
import com.example.gianni.sdpprototype.Models.WorkshopSet;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gianni on 7/09/2016.
 */
public class UpcomingSessionsFragment extends ListFragment {

    FragmentCallback mCallback;
    View upcomingSessions;
    ArrayList<WorkshopSet> items;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        RestClient client = new RestClient();
        Call<GenericResponse<List<WorkshopSet>>> call = client.getHelpsService().getWorkshopSets(true);

        call.enqueue(new Callback<GenericResponse<List<WorkshopSet>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<WorkshopSet>>> call, Response<GenericResponse<List<WorkshopSet>>> response)
            {
                items = new ArrayList<WorkshopSet>(response.body().getResult());
                WorkshopSetListAdapter adapter = new WorkshopSetListAdapter(getActivity(), R.layout.workshop_set_item_layout, items);
                setListAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GenericResponse<List<WorkshopSet>>> call, Throwable t)
            {
                int i = 0;
            }
        });
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mCallback = (FragmentCallback) activity;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + "must implement");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        WorkshopSet set = items.get(position);
        mCallback.onWorkshopSetItemSelected(set.getId());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        upcomingSessions = inflater.inflate(R.layout.upcoming_sessions, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_upcoming_sessions);

        return upcomingSessions;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.upcoming_session_custom_bar, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.menu_upcoming_sessions_search)
        {
            mCallback.onWorkshopSearchIconSelected();
        }

        return true;
    }
}

