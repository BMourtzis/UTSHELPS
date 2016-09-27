package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gianni.sdpprototype.Adapters.BookingListAdapter;
import com.example.gianni.sdpprototype.Models.Booking;
import com.example.gianni.sdpprototype.Models.WorkshopSet;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gianni on 7/09/2016.
 */
public class BookingsFragment extends ListFragment {

    OnBookingListener mCallback;
    View bookingsView;
    ArrayList<Booking> items;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        RestClient client = new RestClient();
        Call<GenericResponse<List<Booking>>> call = client.getHelpsService().getBookingList("11386617");

        call.enqueue(new Callback<GenericResponse<List<Booking>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<Booking>>> call, Response<GenericResponse<List<Booking>>> response) {
                items = new ArrayList<Booking>(response.body().getResult());
                BookingListAdapter adpater = new BookingListAdapter(getActivity(), R.layout.booking_list_item, items);
                setListAdapter(adpater);
            }

            @Override
            public void onFailure(Call<GenericResponse<List<Booking>>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        Booking booking = items.get(position);
        mCallback.onBookingItemSelected(booking.getBookingId());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bookingsView = inflater.inflate(R.layout.bookings, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_bookings);
        return bookingsView;
    }

    public interface OnBookingListener{
        public void onBookingItemSelected(int id);
    }
}
