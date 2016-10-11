package com.example.gianni.sdpprototype.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gianni.sdpprototype.Adapters.WorkshopListAdapter;
import com.example.gianni.sdpprototype.FragmentCallback;
import com.example.gianni.sdpprototype.Models.Workshop;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vasil on 8/10/2016.
 */

public class WorkshopSearchResultFragment extends ListFragment {
    FragmentCallback mCallback;
    View searchResultView;
    ArrayList<Workshop> items;
    int page;
    final int pageSize = 20;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        page = 1;
        Bundle args = getArguments();

        int cId = args.getInt("campusId");
        int wsId = args.getInt("wsId");
        String startBegin = args.getString("StartBegin", "");
        String startEnd = args.getString("StartEnd", "");

        String CampusId = "";
        String WorkshopId = "";

        if(cId != 0)
        {
            CampusId = Integer.toString(cId);
        }

        if(wsId != 0)
        {
            WorkshopId = Integer.toString(wsId);
        }

        RestClient client = new RestClient();
        Call<GenericResponse<List<Workshop>>> call = client.getHelpsService().searchWorkshops(CampusId, WorkshopId, startBegin, startEnd, true, ++page, pageSize);

        call.enqueue(new Callback<GenericResponse<List<Workshop>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<Workshop>>> call, Response<GenericResponse<List<Workshop>>> response)
            {
                items = new ArrayList<Workshop>(response.body().getResult());
                WorkshopListAdapter adapter = new WorkshopListAdapter(getActivity(), R.layout.workshop_set_item_layout, items);
                setListAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GenericResponse<List<Workshop>>> call, Throwable t)
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
        Workshop workshop = items.get(position);
        mCallback.onWorkshopItemSelected(workshop.getWorkshopId());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        searchResultView = inflater.inflate(R.layout.workshop_search_result_layout, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.search_result_title);

        return searchResultView;
    }
}
