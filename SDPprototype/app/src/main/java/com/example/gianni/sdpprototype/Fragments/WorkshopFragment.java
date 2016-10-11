package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gianni.sdpprototype.Models.Booking;
import com.example.gianni.sdpprototype.Models.Workshop;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.Responses.ResponseType;
import com.example.gianni.sdpprototype.Responses.WaitingListResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vasil on 4/10/2016.
 */

public class WorkshopFragment extends Fragment
{
    View workshopView;
    Workshop item;
    List<Booking> items = new ArrayList<Booking>();
    boolean isbooked = false;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        int id = args.getInt("id");

        RestClient client = new RestClient();

        Call<GenericResponse<List<Workshop>>> call = client.getHelpsService().getWorkshop(id);

        call.enqueue(new Callback<GenericResponse<List<Workshop>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<Workshop>>> call, Response<GenericResponse<List<Workshop>>> response)
            {
                item = response.body().getResult().get(0);

                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(item.getTopic());

                TextView campuText = (TextView) workshopView.findViewById(R.id.workshop_details_value_campus);
                campuText.setText(item.getCampus());

                TextView descText = (TextView) workshopView.findViewById(R.id.workshop_details_value_description);
                descText.setText(item.getDescription());

                TextView startingText = (TextView) workshopView.findViewById(R.id.workshop_details_value_starting);
                startingText.setText(item.getStartDate());

                TextView endingText = (TextView) workshopView.findViewById(R.id.workshop_details_value_ending);
                endingText.setText(item.getEndDate());

                TextView targetText = (TextView) workshopView.findViewById(R.id.workshop_details_value_target);
                targetText.setText(item.getTargetingGroup());

                if(item.getBookingCount() >= item.getMaximum())
                {
                    Button button = (Button) workshopView.findViewById(R.id.workshop_booking_button);
                    button.setText("Add to Waiting List");
                }
                checkIfBooked(item.getWorkshopId());
            }

            @Override
            public void onFailure(Call<GenericResponse<List<Workshop>>> call, Throwable t)
            {
                int i = 0;
            }
        });

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_upcoming_sessions);
    }

    private View.OnClickListener getClickListerner(final int workshopId)
    {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                SharedPreferences sharedPrefs = getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
                String studentId = sharedPrefs.getString("studentId", "error");
                int stId = Integer.parseInt(studentId);

                RestClient client = new RestClient();

                if(item.getBookingCount() >= item.getMaximum())
                {
                    Call<ResponseType> call = client.getHelpsService().createWaiting(workshopId, studentId, stId);

                    call.enqueue(new Callback<ResponseType>() {
                        @Override
                        public void onResponse(Call<ResponseType> call, Response<ResponseType> response)
                        {
                            if(response.body().getSuccess())
                            {
                                Button button = (Button) view.findViewById(R.id.workshop_booking_button);
                                button.setText("In Waiting List");

                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseType> call, Throwable t) {

                        }
                    });
                }
                else
                {
                    Call<ResponseType> call = client.getHelpsService().createBooking(workshopId, studentId, stId);

                    call.enqueue(new Callback<ResponseType>() {
                        @Override
                        public void onResponse(Call<ResponseType> call, Response<ResponseType> response)
                        {
                            if(response.body().getSuccess())
                            {
                                Button button = (Button) view.findViewById(R.id.workshop_booking_button);
                                button.setText("Booked");
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseType> call, Throwable t) {
                            int i = 0;
                        }
                    });
                }
            }
        };

        return listener;
    }

    private void checkIfBooked(final int workshopId)
    {
        SharedPreferences sharedPrefs = getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
        String studentId = sharedPrefs.getString("studentId", "error");

        RestClient client = new RestClient();
        Call<GenericResponse<List<Booking>>> call = client.getHelpsService().getBookingList(studentId, true, 0, 2000);

        call.enqueue(new Callback<GenericResponse<List<Booking>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<Booking>>> call, Response<GenericResponse<List<Booking>>> response)
            {
                items = response.body().getResult();
                Button button = (Button) workshopView.findViewById(R.id.workshop_booking_button);

                for(int i = 0; i < items.size(); i++)
                {
                    if(items.get(i).getWorkshopID() == workshopId)
                    {
                        button.setText("Booked");
                        isbooked = true;
                        break;
                    }
                }

                if(!isbooked)
                {
                    button.setOnClickListener(getClickListerner(item.getWorkshopId()));
                }
            }

            @Override
            public void onFailure(Call<GenericResponse<List<Booking>>> call, Throwable t) {

            }
        });
    }

    private void checkIfWaiting(final int workshop)
    {
        SharedPreferences sharedPrefs = getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
        String studentId = sharedPrefs.getString("studentId", "error");

        RestClient client = new RestClient();
        Call<WaitingListResponse> call = client.getHelpsService().getIfWaiting(workshop, studentId);

        call.enqueue(new Callback<WaitingListResponse>() {
            @Override
            public void onResponse(Call<WaitingListResponse> call, Response<WaitingListResponse> response) {
                if(response.body().isWaitingList())
                {
                    Button button = (Button) workshopView.findViewById(R.id.workshop_booking_button);
                    button.setText("Already in Waiting List");
                    button.setBackgroundColor(100);
                }
            }

            @Override
            public void onFailure(Call<WaitingListResponse> call, Throwable t) {

            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        workshopView = inflater.inflate(R.layout.workshop_details, container, false);

        return workshopView;
    }


}
