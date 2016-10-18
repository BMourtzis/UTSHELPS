package com.example.gianni.sdpprototype;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.gianni.sdpprototype.Models.StudentReg;
import com.example.gianni.sdpprototype.Responses.ResponseType;
import com.example.gianni.sdpprototype.RestService.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gianni on 7/09/2016.
 */
public class Register extends AppCompatActivity {

    private DatePickerDialog mPickerDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button button3 = (Button) findViewById(R.id.create_account_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dob = "";
                String gender = "O";
                String degree = "";
                String status = "";

                EditText dayText = (EditText) findViewById(R.id.register_day);
                EditText monthText = (EditText) findViewById(R.id.register_month);
                EditText yearText = (EditText) findViewById(R.id.register_year);

                dob = dayText.getText().toString()+"/"+monthText.getText().toString()+"/"+yearText.getText().toString();

                RadioGroup genderRadio = (RadioGroup) findViewById(R.id.register_gender_radio);
                int genderbuttonId = genderRadio.getCheckedRadioButtonId();
                if(genderbuttonId == R.id.register_gender_male)
                {
                    gender = "M";
                }
                else if(genderbuttonId == R.id.register_gender_female)
                {
                    gender = "F";
                }

                RadioGroup degreeRadio = (RadioGroup) findViewById(R.id.register_degree_radio);
                int degreebuttonId = degreeRadio.getCheckedRadioButtonId();
                if(degreebuttonId == R.id.register_degree_under)
                {
                    degree = "U";
                }
                else if(degreebuttonId == R.id.register_degree_post)
                {
                    degree = "P";
                }

                RadioGroup statusRadio = (RadioGroup) findViewById(R.id.register_status_radio);
                int statusbuttonId = statusRadio.getCheckedRadioButtonId();
                if(statusbuttonId == R.id.register_status_perm)
                {
                    status = "Permanent";
                }
                else if(statusbuttonId == R.id.register_status_int)
                {
                    status = "International";
                }

                EditText studentIdText = (EditText) findViewById(R.id.student_id);
                EditText nameText = (EditText) findViewById(R.id.preffered_name);
                EditText langText = (EditText) findViewById(R.id.first_language);
                EditText countryText = (EditText) findViewById(R.id.country_of_origin);

                StudentReg student = new StudentReg(studentIdText.getText().toString(), dob, nameText.getText().toString(), degree, gender, status, langText.getText().toString(), countryText.getText().toString(), 1);

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

