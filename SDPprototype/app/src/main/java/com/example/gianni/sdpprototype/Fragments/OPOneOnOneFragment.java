package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gianni.sdpprototype.R;

/**
 * Created by Gianni on 19/10/2016.
 */

public class OPOneOnOneFragment extends Fragment {

    View aboutView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        aboutView = inflater.inflate(R.layout.op_one_on_one, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_other_one_no_tab);

        TextView textLink = (TextView) aboutView.findViewById(R.id.one_on_one_link);
        textLink.setMovementMethod(LinkMovementMethod.getInstance());

        return aboutView;
    }
}
