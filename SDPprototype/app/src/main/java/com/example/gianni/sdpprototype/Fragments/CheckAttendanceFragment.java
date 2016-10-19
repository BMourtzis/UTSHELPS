package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gianni.sdpprototype.R;

/**
 * Created by Gianni on 7/09/2016.
 */
public class CheckAttendanceFragment extends Fragment {

    View checkAttendance;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        checkAttendance = inflater.inflate(R.layout.check_attendance, container, false);
        
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_check_attendance);

        SharedPreferences sharedPrefs = this.getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
        String serial = sharedPrefs.getString("serial", "");

        TextView serialText = (TextView) checkAttendance.findViewById(R.id.serial);
        serialText.setText(serial);

        return checkAttendance;
    }

}

