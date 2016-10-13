package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
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
 * Created by Vasil on 6/10/2016.
 */

public class FAQFragment extends Fragment{
    View FAQView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FAQView = inflater.inflate(R.layout.faq_layout, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_faq);

        Button button1 = (Button) FAQView.findViewById(R.id.faq_q1_button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.faq_q1_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button2 = (Button) FAQView.findViewById(R.id.faq_q2_button);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.faq_q2_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button3 = (Button) FAQView.findViewById(R.id.faq_q3_button);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.faq_q3_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button4 = (Button) FAQView.findViewById(R.id.faq_q4_button);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.faq_q4_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button5 = (Button) FAQView.findViewById(R.id.faq_q5_button);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.faq_q5_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button6 = (Button) FAQView.findViewById(R.id.faq_q6_button);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.faq_q6_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button7 = (Button) FAQView.findViewById(R.id.faq_q7_button);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.faq_q7_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button8 = (Button) FAQView.findViewById(R.id.faq_q8_button);
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.faq_q8_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        Button button9 = (Button) FAQView.findViewById(R.id.faq_q9_button);
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = (TextView) FAQView.findViewById(R.id.faq_q9_text);
                text.setVisibility(text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        return FAQView;
    }
}
