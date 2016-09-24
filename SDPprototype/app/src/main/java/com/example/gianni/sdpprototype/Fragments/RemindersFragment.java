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
 * Created by Gianni on 7/09/2016.
 */
public class RemindersFragment extends Fragment {

    View remindersView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        remindersView = inflater.inflate(R.layout.reminders, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_reminders);
        return remindersView;
    }
}
