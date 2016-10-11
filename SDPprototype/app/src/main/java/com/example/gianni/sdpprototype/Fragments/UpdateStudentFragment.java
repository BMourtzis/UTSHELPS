package com.example.gianni.sdpprototype.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gianni.sdpprototype.FragmentCallback;
import com.example.gianni.sdpprototype.LoginActivity;
import com.example.gianni.sdpprototype.Models.Student;
import com.example.gianni.sdpprototype.Models.StudentReg;
import com.example.gianni.sdpprototype.R;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.Responses.ResponseType;
import com.example.gianni.sdpprototype.RestService.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vasil on 9/10/2016.
 */

public class UpdateStudentFragment extends Fragment {
    View updateStudentView;
    FragmentCallback mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        updateStudentView = inflater.inflate(R.layout.update_student_layout, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_update_student);

        SharedPreferences sharedPrefs = getActivity().getSharedPreferences("utshelps", Context.MODE_PRIVATE);
        final String studentId = sharedPrefs.getString("studentId", "error");

        RestClient client = new RestClient();
        Call<GenericResponse<Student>> call = client.getHelpsService().getStudent(studentId);

        call.enqueue(new Callback<GenericResponse<Student>>() {
            @Override
            public void onResponse(Call<GenericResponse<Student>> call, Response<GenericResponse<Student>> response) {
                Student student = response.body().getResult();

                EditText dobText = (EditText) updateStudentView.findViewById(R.id.register_dob_edit);
                if(student.getDob() != null) {
                    dobText.setText(student.getDob().trim());
                }
                EditText nameText = (EditText) updateStudentView.findViewById(R.id.register_name_edit);
                if(student.getPreferredName() != null) {
                    nameText.setText(student.getPreferredName().trim());
                }
                EditText genderText = (EditText) updateStudentView.findViewById(R.id.register_gender_edit);
                if(student.getGender() != null) {
                    genderText.setText(student.getGender().trim());
                }
                EditText degreeText = (EditText) updateStudentView.findViewById(R.id.register_degree_edit);
                if(student.getDegree() != null) {
                    degreeText.setText(student.getDegree().trim());
                }
                EditText statusText = (EditText) updateStudentView.findViewById(R.id.register_status_edit);
                if(student.getStatus() != null) {
                    statusText.setText(student.getStatus().trim());
                }
                EditText langText = (EditText) updateStudentView.findViewById(R.id.register_lang_edit);
                if(student.getFirstLanguage() != null) {
                    langText.setText(student.getFirstLanguage().trim());
                }
                EditText countryText = (EditText) updateStudentView.findViewById(R.id.register_country_edit);
                if(student.getCountry_origin() != null) {
                    countryText.setText(student.getCountry_origin().trim());
                }
            }

            @Override
            public void onFailure(Call<GenericResponse<Student>> call, Throwable t) {

            }
        });

        Button button3 = (Button) updateStudentView.findViewById(R.id.update_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dobText = (EditText) updateStudentView.findViewById(R.id.register_dob_edit);
                EditText nameText = (EditText) updateStudentView.findViewById(R.id.register_name_edit);
                EditText genderText = (EditText) updateStudentView.findViewById(R.id.register_gender_edit);
                EditText degreeText = (EditText) updateStudentView.findViewById(R.id.register_degree_edit);
                EditText statusText = (EditText) updateStudentView.findViewById(R.id.register_status_edit);
                EditText langText = (EditText) updateStudentView.findViewById(R.id.register_lang_edit);
                EditText countryText = (EditText) updateStudentView.findViewById(R.id.register_country_edit);

                StudentReg student = new StudentReg(studentId, dobText.getText().toString(), nameText.getText().toString(), degreeText.getText().toString(), genderText.getText().toString(), statusText.getText().toString(), langText.getText().toString(), countryText.getText().toString(), 1);

                RestClient client = new RestClient();
                Call<ResponseType> call = client.getHelpsService().registerStudent(student);

                call.enqueue(new Callback<ResponseType>() {
                    @Override
                    public void onResponse(Call<ResponseType> call, Response<ResponseType> response) {
                        if(response.body().getSuccess() == true)
                        {
                            mCallback.StudentUpdated();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseType> call, Throwable t) {
                        int i = 0;
                    }
                });
            }
        });

        return updateStudentView;
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
