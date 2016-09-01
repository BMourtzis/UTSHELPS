package com.example.vm.utshelpsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewBookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Retrofit retro = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();
        GitHubService service = retro.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("BMourtzis");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bookings);
    }
}
