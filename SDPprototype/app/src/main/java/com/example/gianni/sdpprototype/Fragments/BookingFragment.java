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

import com.example.gianni.sdpprototype.Models.Booking;
import com.example.gianni.sdpprototype.Models.Campus;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.Responses.ResponseType;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(item.getTopic());

        TextView descText = (TextView) accountView.findViewById(R.id.booking_details_value_description);
        descText.setText(item.getDescription());

        TextView startingText = (TextView) accountView.findViewById(R.id.booking_details_value_starting);
        startingText.setText(item.getStarting());

        TextView endingText = (TextView) accountView.findViewById(R.id.booking_details_value_ending);
        endingText.setText(item.getEnding());

        Button button = (Button) accountView.findViewById(R.id.booking_cancel_button);

        button.setOnClickListener(getOnClickListerner(item.getWorkshopID()));


        RestClient client = new RestClient();
        Call<GenericResponse<List<Campus>>> call = client.getHelpsService().getCampusList(true);

        return accountView;
    }

    private View.OnClickListener getOnClickListerner(final int workshopId)
    {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                SharedPreferences sharedPrefs = getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
                String studentId = sharedPrefs.getString("studentId", "error");
                int stId = Integer.parseInt(studentId);

                RestClient client = new RestClient();
                Call<ResponseType> call = client.getHelpsService().cancelBooking(workshopId, studentId, stId);

                call.enqueue(new Callback<ResponseType>() {
                    @Override
                    public void onResponse(Call<ResponseType> call, Response<ResponseType> response)
                    {
                        boolean isSuc = response.body().getSuccess();
                        if(isSuc)
                        {
                            Button button = (Button) view.findViewById(R.id.booking_cancel_button);
                            button.setText("Cancelled");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseType> call, Throwable t) {
                        int i = 0;
                    }
                });
            }
        };
        return listener;
    }
}
