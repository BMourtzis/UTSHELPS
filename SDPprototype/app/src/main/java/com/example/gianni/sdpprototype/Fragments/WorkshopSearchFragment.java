package com.example.gianni.sdpprototype.Fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.gianni.sdpprototype.FragmentCallback;
import com.example.gianni.sdpprototype.Models.Campus;
import com.example.gianni.sdpprototype.Models.WorkshopSet;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;
import com.example.gianni.sdpprototype.Utilities;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vasil on 7/10/2016.
 */

public class WorkshopSearchFragment extends Fragment {
    FragmentCallback mCallback;
    View searchView;

    Spinner campusSpinner;
    Spinner wsSpinner;

    EditText startText;
    EditText endText;

    DatePickerDialog mPickerDialogStart;
    DatePickerDialog mPickerDialogEnd;

    List<Campus> campuses;
    List<WorkshopSet> workshopSets;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        searchView = inflater.inflate(R.layout.workshop_search_layout, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.upcoming_sessions_search);

        startText = (EditText) searchView.findViewById(R.id.search_edit_starting_begin);
        endText = (EditText) searchView.findViewById(R.id.search_edit_starting_end);

        startText.setInputType(0x00000000);
        endText.setInputType(0x00000000);

        mPickerDialogStart = setUpCalendarPrompt(startText);
        mPickerDialogEnd = setUpCalendarPrompt(endText);

        startText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =  v.getId();
                if(id == R.id.search_edit_starting_begin ){
                     mPickerDialogStart.show();
                }
            }
        });

        endText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =  v.getId();
                if(id == R.id.search_edit_starting_end ){
                    mPickerDialogEnd.show();
                }
            }
        });

        RestClient client = new RestClient();
        Call<GenericResponse<List<Campus>>> callcampus = client.getHelpsService().getCampusList(true);

        campusSpinner = (Spinner) searchView.findViewById(R.id.search_edit_campus_spinner);

        callcampus.enqueue(new Callback<GenericResponse<List<Campus>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<Campus>>> call, Response<GenericResponse<List<Campus>>> response) {
                campuses = response.body().getResult();
                Campus defaultCampus = new Campus("Select Campus");
                campuses.add(0, defaultCampus);

                ArrayAdapter<Campus> adapter = new ArrayAdapter<Campus>(getActivity(), R.layout.support_simple_spinner_dropdown_item, campuses);
                campusSpinner.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GenericResponse<List<Campus>>> call, Throwable t) {

            }
        });

        Call<GenericResponse<List<WorkshopSet>>> wscall = client.getHelpsService().getWorkshopSets(true);

        wsSpinner = (Spinner) searchView.findViewById(R.id.search_edit_workshop_set_spinner);

        wscall.enqueue(new Callback<GenericResponse<List<WorkshopSet>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<WorkshopSet>>> call, Response<GenericResponse<List<WorkshopSet>>> response) {
                workshopSets = response.body().getResult();
                WorkshopSet ws = new WorkshopSet("Select WorkshopSet");
                workshopSets.add(0, ws);

                ArrayAdapter<WorkshopSet> adapter = new ArrayAdapter<WorkshopSet>(getActivity(), R.layout.support_simple_spinner_dropdown_item, workshopSets);
                wsSpinner.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GenericResponse<List<WorkshopSet>>> call, Throwable t) {

            }
        });

        Button searchButton = (Button) searchView.findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int campusId = 0;
                int wsId = 0;

                if(campusSpinner.getSelectedItemPosition() != 0)
                {
                    campusId = campuses.get(campusSpinner.getSelectedItemPosition()).getId();
                }

                if(wsSpinner.getSelectedItemPosition() != 0)
                {
                    wsId = workshopSets.get(wsSpinner.getSelectedItemPosition()).getId();
                }

                String StartBegin = startText.getText().toString();
                String StartEnd = endText.getText().toString();

                if(campusId != 0 || wsId != 0 || (!StartBegin.equals("") && !StartEnd.equals("")))
                {
                    mCallback.onSearchWorkshops(campusId, wsId, StartBegin, StartEnd);
                }
            }
        });

        return searchView;
    }

    private DatePickerDialog setUpCalendarPrompt( final EditText text){
        Calendar calendar = Calendar.getInstance();
        int startYear = calendar.get(Calendar.YEAR);
        int starthMonth = calendar.get(Calendar.MONTH);
        int startDate = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datepicker = new DatePickerDialog(getActivity(), R.style.DatePickerTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = Utilities.getFormattedDate(dayOfMonth, month + 1, year);
                text.setText(date);
            }
        }, startYear, starthMonth, startDate);

        return datepicker;
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mCallback = (FragmentCallback) activity;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + "must implement");
        }
    }
}
