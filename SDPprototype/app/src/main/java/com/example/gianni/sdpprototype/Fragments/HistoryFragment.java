package com.example.gianni.sdpprototype.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gianni.sdpprototype.Adapters.BookingListAdapter;
import com.example.gianni.sdpprototype.FragmentCallback;
import com.example.gianni.sdpprototype.Models.Booking;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gianni on 7/09/2016.
 */
public class HistoryFragment extends ListFragment {

    View historyView;
    ArrayList<Booking> items;
    FragmentCallback mCallback;
    int currectPage = 1;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPrefs = getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
        String studentId = sharedPrefs.getString("studentId", "error");

        RestClient client = new RestClient();
        Call<GenericResponse<List<Booking>>> call = client.getHelpsService().getBookingList(studentId, currectPage, 20);
        currectPage++;

        call.enqueue(new Callback<GenericResponse<List<Booking>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<Booking>>> call, Response<GenericResponse<List<Booking>>> response) {
                items = new ArrayList<Booking>(response.body().getResult());

                for(int i = 0; i<items.size(); i++)
                {
                    if(items.get(i).getBookingArchived() == null)
                    {
                        items.remove(i);
                    }
                }

                Collections.sort(items);

                BookingListAdapter adapter = new BookingListAdapter(getActivity(), R.layout.history, items);
                setListAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GenericResponse<List<Booking>>> call, Throwable t)
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
        Booking booking = items.get(position);
        mCallback.onBookingItemSelected(booking);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        historyView = inflater.inflate(R.layout.history, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_history);

        return historyView;
    }

//    private ArrayList<Booking> getPastBooking(ArrayList<Booking> home)
//    {
//
//    }
}
