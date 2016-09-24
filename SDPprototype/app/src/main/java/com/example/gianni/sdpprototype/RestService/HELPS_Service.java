package com.example.gianni.sdpprototype.RestService;

import com.example.gianni.sdpprototype.Responses.StudentResponse;
import com.example.gianni.sdpprototype.Responses.WorkshopSetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Vasil on 23/9/2016.
 */
public interface HELPS_Service
{
    @Headers("AppKey:123456")
    @GET("student/get")
    Call<StudentResponse> getStudent(@Query("studentId") String studentId);

    @Headers("AppKey:123456")
    @GET("workshop/workshopSets")
    Call<WorkshopSetResponse> getWorkshopSets(@Query("active") boolean active);
}
