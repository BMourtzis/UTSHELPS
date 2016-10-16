package com.example.gianni.sdpprototype.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gianni.sdpprototype.Adapters.WaitingListAdapter;
import com.example.gianni.sdpprototype.FragmentCallback;
import com.example.gianni.sdpprototype.Models.Waiting;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.WaitingListResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vasil on 16/10/2016.
 */

public class WaitingListFragment extends ListFragment {
    FragmentCallback mCallback;
    View waitingListView;
    ArrayList<Waiting> items;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        waitingListView = inflater.inflate(R.layout.waiting_list_layout, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_waiting_list);

        SharedPreferences sharedPrefs = getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
        String studentId = sharedPrefs.getString("studentId", "error");

        RestClient client = new RestClient();
        Call<WaitingListResponse> call = client.getHelpsService().getWaitingList(studentId);

        call.enqueue(new Callback<WaitingListResponse>() {
            @Override
            public void onResponse(Call<WaitingListResponse> call, Response<WaitingListResponse> response) {
                items = new ArrayList<Waiting>(response.body().getWaitings());
                WaitingListAdapter adapter = new WaitingListAdapter(getActivity(), R.layout.waiting_list_item, items);
                setListAdapter(adapter);
            }

            @Override
            public void onFailure(Call<WaitingListResponse> call, Throwable t) {

            }
        });

        return waitingListView;
    }

}
