package com.example.gianni.sdpprototype.RestService;

import com.example.gianni.sdpprototype.Models.Booking;
import com.example.gianni.sdpprototype.Models.Campus;
import com.example.gianni.sdpprototype.Models.Student;
import com.example.gianni.sdpprototype.Models.Workshop;
import com.example.gianni.sdpprototype.Models.WorkshopSet;
import com.example.gianni.sdpprototype.Responses.GenericResponse;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Vasil on 23/9/2016.
 */
public interface HELPS_Service
{
    @Headers("AppKey:123456")
    @GET("student/get")
    Call<GenericResponse<Student>> getStudent(@Query("studentId") String studentId);

    @Headers("AppKey:123456")
    @GET("workshop/workshopSets")
    Call<GenericResponse<List<WorkshopSet>>> getWorkshopSets(@Query("active") boolean active);

    @Headers("AppKey:123456")
    @GET("workshop/search")
    Call<GenericResponse<List<Workshop>>>  getWorkshopList(@Query("workshopSet") int workshopset);

    @Headers("AppKey:123456")
    @GET("misc/campus")
    Call<GenericResponse<List<Campus>>> getCampusList(@Query("active") boolean active);

    @Headers("AppKey:123456")
    @GET("workshop/booking/search")
    Call<GenericResponse<List<Booking>>>  getBookingList(@Query("StudentId") String studentId);

    @Headers({
            "AppKey:123456",
            "Content-Type:application/json"
    })
    @POST("student/register")
    Call<GenericResponse<Objects>> registerStudent(@Body Student student);

    @Headers("AppKey:123456")
    @POST("workshop/booking/create")
    Call<GenericResponse<Objects>> createBooking(@Query("workshopId") int workshopId, @Query("studentId") String studentId, @Query("userId") int userId);
}
