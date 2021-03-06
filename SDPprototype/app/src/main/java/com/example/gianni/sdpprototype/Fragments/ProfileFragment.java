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
import android.widget.TextView;

import com.example.gianni.sdpprototype.Models.Student;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gianni on 7/09/2016.
 */
public class ProfileFragment extends Fragment {

    View accountView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        accountView = inflater.inflate(R.layout.profile, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_account);

        SharedPreferences sharedPrefs = getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
        String studentId = sharedPrefs.getString("studentId", "error");

        RestClient client = new RestClient();
        Call<GenericResponse<Student>> call = client.getHelpsService().getStudent(studentId);

        call.enqueue(new Callback<GenericResponse<Student>>() {
            @Override
            public void onResponse(Call<GenericResponse<Student>> call, Response<GenericResponse<Student>> response)
            {
                Student student = response.body().getResult();

                TextView idText = (TextView) accountView.findViewById(R.id.student_id);
                idText.setText(student.getStudentID());

                TextView genderText = (TextView) accountView.findViewById(R.id.gender);
                genderText.setText(student.getGender());

                TextView degreeText = (TextView) accountView.findViewById(R.id.degree);
                degreeText.setText(student.getDegree());

                TextView statusText = (TextView) accountView.findViewById(R.id.status);
                statusText.setText(student.getStatus());
            }

            @Override
            public void onFailure(Call<GenericResponse<Student>> call, Throwable t)
            {
                int i = 0;
            }
        });

        return accountView;
    }
}
