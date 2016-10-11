package com.example.gianni.sdpprototype.RestService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vasil on 23/9/2016.
 */
public class RestClient
{
    private HELPS_Service helpsService;

    public RestClient()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://40.126.224.186/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        helpsService = retrofit.create(HELPS_Service.class);
    }

    public HELPS_Service getHelpsService() {
        return helpsService;
    }
}
