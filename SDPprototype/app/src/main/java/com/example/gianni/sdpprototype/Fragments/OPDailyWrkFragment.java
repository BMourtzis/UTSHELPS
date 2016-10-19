package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gianni.sdpprototype.R;

/**
 * Created by Gianni on 19/10/2016.
 */

public class OPDailyWrkFragment extends Fragment {

    View aboutView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        aboutView = inflater.inflate(R.layout.op_daily_workshops, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_other_workshops_no_tab);

        return aboutView;
    }
}
