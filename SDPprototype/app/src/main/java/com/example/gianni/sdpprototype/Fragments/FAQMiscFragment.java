package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gianni.sdpprototype.R;

/**
 * Created by Vasil on 9/10/2016.
 */

public class FAQMiscFragment extends Fragment {
    View FAQView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FAQView = inflater.inflate(R.layout.faq_misc_layout, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_faq_misc_no_tab);

        Button button1 = (Button) FAQView.findViewById(R.id.misc_q1_button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.misc_q1_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button2 = (Button) FAQView.findViewById(R.id.misc_q2_button);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.misc_q2_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button3 = (Button) FAQView.findViewById(R.id.misc_q3_button);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.misc_q3_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button4 = (Button) FAQView.findViewById(R.id.misc_q4_button);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.misc_q4_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button5 = (Button) FAQView.findViewById(R.id.misc_q5_button);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text1 = (TextView) FAQView.findViewById(R.id.misc_q5_text1);
                text1.setVisibility(text1.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);

                TextView text2 = (TextView) FAQView.findViewById(R.id.misc_q5_text2);
                text2.setVisibility(text2.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        TextView textLink1 = (TextView) FAQView.findViewById(R.id.misc_q4_text);
        textLink1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textLink2 = (TextView) FAQView.findViewById(R.id.misc_q5_text1);
        textLink2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textLink3 = (TextView) FAQView.findViewById(R.id.misc_q5_text2);
        textLink3.setMovementMethod(LinkMovementMethod.getInstance());

        return FAQView;
    }
}
