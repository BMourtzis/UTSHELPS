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
import com.example.gianni.sdpprototype.R;


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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_account);

        return accountView;
    }
}
