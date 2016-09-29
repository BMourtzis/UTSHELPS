package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gianni.sdpprototype.Models.Booking;
import com.example.gianni.sdpprototype.Models.Campus;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Vasil_000 on 28/9/2016.
 */
public class BookingFragment extends Fragment {
    View accountView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        accountView = inflater.inflate(R.layout.booking_details_layout, container, false);

        Bundle args = getArguments();
        Booking item = args.getParcelable("booking");

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(item.getTopic());

        TextView descText = (TextView) accountView.findViewById(R.id.booking_details_value_description);
        descText.setText(item.getDescription());

        TextView startingText = (TextView) accountView.findViewById(R.id.booking_details_value_starting);
        startingText.setText(item.getStarting());

        TextView endingText = (TextView) accountView.findViewById(R.id.booking_details_value_ending);
        endingText.setText(item.getEnding());

        RestClient client = new RestClient();
        Call<GenericResponse<List<Campus>>> call = client.getHelpsService().getCampusList(true);

        return accountView;
    }
}
