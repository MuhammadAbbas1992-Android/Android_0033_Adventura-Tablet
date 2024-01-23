package com.example.adventura.repository;

import com.example.adventura.models.LapHitDataRequest;
import com.example.adventura.models.UserLoginData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    //    String BASE_URL = "https://wallofjobs.com/";
    @POST("m_lc_login")
    Call<ApiResponse> userLoginData(@Body UserLoginData body);

    @GET("m_get_tracklist")
    Call<ApiResponse> listTrackData();

    @POST("m_lap_hit")
    Call<ApiResponse> lapCountingData(@Body LapHitDataRequest body);

    @GET("m_get_racerslist")
    Call<ApiResponse> listRacersData();
}