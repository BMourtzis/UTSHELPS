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
import android.widget.Toast;

import com.example.gianni.sdpprototype.Models.Booking;
import com.example.gianni.sdpprototype.Models.BookingUpdateModel;
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
    View bookingView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        bookingView = inflater.inflate(R.layout.booking_details_layout, container, false);

        Bundle args = getArguments();
        final Booking item = args.getParcelable("booking");

        SharedPreferences sharedPrefs = getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
        final String studentId = sharedPrefs.getString("studentId", "error");

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(item.getTopic());

        TextView descText = (TextView) bookingView.findViewById(R.id.booking_details_value_description);
        descText.setText(item.getDescription());

        TextView startingText = (TextView) bookingView.findViewById(R.id.booking_details_value_starting);
        startingText.setText(item.getStarting());

        TextView endingText = (TextView) bookingView.findViewById(R.id.booking_details_value_ending);
        endingText.setText(item.getEnding());

        Button button = (Button) bookingView.findViewById(R.id.booking_cancel_button);

        button.setOnClickListener(getOnClickListerner(item.getWorkshopID()));

        Button attendace = (Button) bookingView.findViewById(R.id.booking_attendance_button);

        attendace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookingUpdateModel model = new BookingUpdateModel(item.workshopID, studentId);

                RestClient client = new RestClient();
                Call<ResponseType> call = client.getHelpsService().updateBooking(model);

                call.enqueue(new Callback<ResponseType>() {
                    @Override
                    public void onResponse(Call<ResponseType> call, Response<ResponseType> response) {
                        if(response.body().getSuccess())
                        {
                            Toast toast = Toast.makeText(getActivity(), "Attendance Recorded.", Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else
                        {
                            Toast toast = Toast.makeText(getActivity(), response.body().getDisplayMessage(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseType> call, Throwable t) {

                    }
                });
            }
        });


        RestClient client = new RestClient();
        Call<GenericResponse<List<Campus>>> call = client.getHelpsService().getCampusList(true);

        call.enqueue(new Callback<GenericResponse<List<Campus>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<Campus>>> call, Response<GenericResponse<List<Campus>>> response) {
                if(response.body().getSuccess())
                {
                    List<Campus> campuses = response.body().getResult();
                    for(Campus cam : campuses)
                    {
                        if(cam.getId() == item.getCampusID())
                        {
                            TextView startingText = (TextView) bookingView.findViewById(R.id.booking_details_value_campus);
                            startingText.setText(cam.getCampus());
                            break;
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GenericResponse<List<Campus>>> call, Throwable t) {

            }
        });

        return bookingView;
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
