package com.example.gianni.sdpprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gianni.sdpprototype.Models.Student;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.RestService.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gianni on 7/09/2016.
 */
public class Register extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button button3 = (Button) findViewById(R.id.create_account_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText studentIdText = (EditText) view.findViewById(R.id.register_id_edit);
                EditText dobText = (EditText) view.findViewById(R.id.register_dob_edit);
                EditText nameText = (EditText) view.findViewById(R.id.register_name_edit);
                EditText genderText = (EditText) view.findViewById(R.id.register_gender_edit);
                EditText degreeText = (EditText) view.findViewById(R.id.register_degree_edit);
                EditText statusText = (EditText) view.findViewById(R.id.register_status_edit);
                EditText langText = (EditText) view.findViewById(R.id.register_lang_edit);
                EditText countryText = (EditText) view.findViewById(R.id.register_country_edit);

                Student student = new Student(studentIdText.toString(), dobText.toString(), nameText.toString(), degreeText.toString(), genderText.toString(), statusText.toString(), langText.toString(), countryText.toString(), 1);

                RestClient client = new RestClient();
                Call<GenericResponse> call = client.getHelpsService().registerStudent(student);

                call.enqueue(new Callback<GenericResponse>() {
                    @Override
                    public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
                        if(response.body().getSuccess() == true)
                        {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<GenericResponse> call, Throwable t) {

                    }
                });
            }
        });
    }

}

