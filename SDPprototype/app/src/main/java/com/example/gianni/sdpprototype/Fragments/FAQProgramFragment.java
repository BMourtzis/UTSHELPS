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
 * Created by Vasil on 6/10/2016.
 */

public class FAQProgramFragment extends Fragment{
    View FAQView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FAQView = inflater.inflate(R.layout.faq_program_layout, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_faq_helps_program);

        return FAQView;
    }
}
