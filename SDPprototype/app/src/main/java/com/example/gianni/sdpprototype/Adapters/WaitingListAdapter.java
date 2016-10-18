package com.example.gianni.sdpprototype.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gianni.sdpprototype.Models.Waiting;
import com.example.gianni.sdpprototype.Models.Workshop;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Vasil on 16/10/2016.
 */

public class WaitingListAdapter extends ArrayAdapter<Waiting>
{
    ArrayList<Waiting> waitings;
    View itemView;

    public WaitingListAdapter(Context context, int textViewResourceId, ArrayList<Waiting> items)
    {
        super(context, textViewResourceId, items);
        this.waitings = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        itemView = convertView;
        if(itemView == null)
        {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = vi.inflate(R.layout.waiting_list_item, null);
        }

        Waiting w = waitings.get(position);

        RestClient client = new RestClient();
        Call<GenericResponse<List<Workshop>>> call = client.getHelpsService().getWorkshop(w.getWorkshopID());

        call.enqueue(new Callback<GenericResponse<List<Workshop>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<Workshop>>> call, Response<GenericResponse<List<Workshop>>> response) {
                if(response.body().getSuccess())
                {
                    Workshop item = response.body().getResult().get(0);

                    TextView topicText = (TextView) itemView.findViewById(R.id.waiting_topic);
                    topicText.setText(item.getTopic());

                    TextView dateText = (TextView) itemView.findViewById(R.id.waiting_date);
                    dateText.setText("Date: "+item.getStartDate());
                }
            }

            @Override
            public void onFailure(Call<GenericResponse<List<Workshop>>> call, Throwable t) {

            }
        });

        return itemView;
    }
}
