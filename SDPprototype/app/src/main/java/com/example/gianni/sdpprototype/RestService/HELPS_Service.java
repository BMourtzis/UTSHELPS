package com.example.gianni.sdpprototype.RestService;

import com.example.gianni.sdpprototype.Models.Booking;
import com.example.gianni.sdpprototype.Models.Campus;
import com.example.gianni.sdpprototype.Models.Student;
import com.example.gianni.sdpprototype.Models.Workshop;
import com.example.gianni.sdpprototype.Models.WorkshopSet;
import com.example.gianni.sdpprototype.Responses.GenericResponse;
import com.example.gianni.sdpprototype.Responses.ResponseType;
import com.example.gianni.sdpprototype.Responses.WaitingListResponse;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Vasil on 23/9/2016.
 */
public interface HELPS_Service
{
    //GETS
    @Headers("AppKey:123456")
    @GET("student")
    Call<GenericResponse<Student>> getStudent(@Query("studentId") String studentId);

    @Headers("AppKey:123456")
    @GET("workshop/workshopSets")
    Call<GenericResponse<List<WorkshopSet>>> getWorkshopSets(@Query("active") boolean active);

    @Headers("AppKey:123456")
    @GET("workshop/search")
    Call<GenericResponse<List<Workshop>>>  getWorkshopList(@Query("WorkshopSetId") int workshopset,  @Query("StartingDtBegin") String StartingDtBegin, @Query("StartingDtEnd") String StartingDtEnd, @Query("Active") boolean active, @Query("Page") int page, @Query("PageSize") int pageSize);

    @Headers("AppKey:123456")
    @GET("misc/campus")
    Call<GenericResponse<List<Campus>>> getCampusList(@Query("active") boolean active);

    @Headers("AppKey:123456")
    @GET("workshop/booking/search")
    Call<GenericResponse<List<Booking>>>  getBookingList(@Query("StudentId") String studentId, @Query("Active") boolean active, @Query("Page") int page, @Query("PageSize") int pageSize);

    @Headers("AppKey:123456")
    @GET("workshop/booking/search")
    Call<GenericResponse<List<Booking>>>  getBookingList(@Query("StudentId") String studentId, @Query("StartingDtBegin") Date StartingDtBegin, @Query("StartingDtEnd") Date StartingDtEnd, @Query("Page") int page, @Query("PageSize") int pageSize);

    @Headers("AppKey:123456")
    @GET("workshop/")
    Call<GenericResponse<List<Workshop>>> getWorkshop(@Query("id") int workshopId);

    @Headers("AppKey:123456")
    @GET("workshop/search")
    Call<GenericResponse<List<Workshop>>> searchWorkshops(@Query("CampusId") String CampusId, @Query("WorkshopSetId") String workshopSetId, @Query("StartingDtBegin") String StartingDtBegin, @Query("StartingDtEnd") String StartingDtEnd, @Query("Active") boolean active, @Query("Page") int page, @Query("PageSize") int pageSize);

    @Headers("AppKey:123456")
    @GET("workshop/wait")
    Call<WaitingListResponse> getIfWaiting(@Query("workshopid") int workshopId, @Query("studentid") String studentId);

    //POSTS
    @Headers({
            "AppKey:123456",
            "Content-Type:application/json"
    })
    @POST("student/register")
    Call<ResponseType> registerStudent(@Body Student student);

    @Headers("AppKey:123456")
    @POST("workshop/booking/create")
    Call<ResponseType> createBooking(@Query("workshopId") int workshopId, @Query("studentId") String studentId, @Query("userId") int userId);

    @Headers("AppKey:123456")
    @POST("workshop/booking/cancel")
    Call<ResponseType> cancelBooking(@Query("workshopId") int workshopId, @Query("studentId") String studentId, @Query("userId") int userId);

    @Headers("AppKey:123456")
    @POST("workshop/wait/create")
    Call<ResponseType> createWaiting(@Query("workshopId") int workshopId, @Query("studentId") String studentId, @Query("userId") int userId);

}
