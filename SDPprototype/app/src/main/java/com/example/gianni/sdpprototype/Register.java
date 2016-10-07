package com.example.gianni.sdpprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gianni.sdpprototype.Models.Student;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.Responses.ResponseType;
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
                EditText studentIdText = (EditText) findViewById(R.id.register_id_edit);
                EditText dobText = (EditText) findViewById(R.id.register_dob_edit);
                EditText nameText = (EditText) findViewById(R.id.register_name_edit);
                EditText genderText = (EditText) findViewById(R.id.register_gender_edit);
                EditText degreeText = (EditText) findViewById(R.id.register_degree_edit);
                EditText statusText = (EditText) findViewById(R.id.register_status_edit);
                EditText langText = (EditText) findViewById(R.id.register_lang_edit);
                EditText countryText = (EditText) findViewById(R.id.register_country_edit);

                Student student = new Student(studentIdText.getText().toString(), dobText.getText().toString(), nameText.getText().toString(), degreeText.getText().toString(), genderText.getText().toString(), statusText.getText().toString(), langText.getText().toString(), countryText.getText().toString(), 1);

                RestClient client = new RestClient();
                Call<ResponseType> call = client.getHelpsService().registerStudent(student);

                call.enqueue(new Callback<ResponseType>() {
                    @Override
                    public void onResponse(Call<ResponseType> call, Response<ResponseType> response) {
                        if(response.body().getSuccess() == true)
                        {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseType> call, Throwable t) {
                        int i = 0;
                    }
                });
            }
        });
    }

}

