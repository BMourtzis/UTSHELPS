package com.example.vm.utshelpsapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vasil_000 on 1/9/2016.
 */
public class RESTClient
{
    final String Base_URL = "https://api.github.com";
    Retrofit retro;

    public RESTClient()
    {
        retro = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public List<Repo> getRepoList(String user)
    {
        GitHubService service = retro.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("BMourtzis");
        List<Repo> returnList;

        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                returnList = response.body();
                int statusCode = response.code();
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
