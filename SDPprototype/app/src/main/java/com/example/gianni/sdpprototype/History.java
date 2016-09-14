package com.example.gianni.sdpprototype;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gianni on 7/09/2016.
 */
public class History extends Fragment {

    View historyView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        historyView = inflater.inflate(R.layout.history, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_history);
        return historyView;
    }
}
