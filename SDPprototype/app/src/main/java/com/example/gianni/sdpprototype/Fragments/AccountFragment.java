package com.example.gianni.sdpprototype.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gianni.sdpprototype.Models.Student;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.StudentResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gianni on 7/09/2016.
 */
public class AccountFragment extends Fragment {

    View accountView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        accountView = inflater.inflate(R.layout.account, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_account);

        RestClient client = new RestClient();
        Call<StudentResponse> call = client.getHelpsService().getStudent("11386617");

        call.enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response)
            {
                Student student = response.body().getStudent();

                TextView idText = (TextView) accountView.findViewById(R.id.account_id_value);
                idText.setText(student.getStudentID());

                TextView genderText = (TextView) accountView.findViewById(R.id.account_gender_value);
                genderText.setText(student.getGender());

                TextView degreeText = (TextView) accountView.findViewById(R.id.account_degree_value);
                degreeText.setText(student.getDegree());

                TextView statusText = (TextView) accountView.findViewById(R.id.account_status_value);
                statusText.setText(student.getStatus());
            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t)
            {

            }
        });

        return accountView;
    }
}
