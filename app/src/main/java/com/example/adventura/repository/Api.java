package com.example.adventura.repository;

import com.example.adventura.models.UserLoginData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "https://wallofjobs.com/";

    @POST("m_lc_login")
    Call<ApiResponse> userLoginData(@Body UserLoginData body);
    @GET("m_get_tracklist")
    Call<ApiResponse> listTrackData();

/*

    @GET("m_get_karts")
    Call<ApiResponse> listKartsData();

    @GET("m_activate_kart/{kart_id}")
    Call<ApiResponse> kartActivateData(@Path("kart_id") String kart_id);

    @GET("m_deactivate_kart/{kart_id}")
    Call<ApiResponse> kartDeactivateData(@Path("kart_id") String kart_id);

    @POST("m_qr_scanned_data")
    Call<ApiResponse> scannedQRCustomersData(@Body CustomerData body);

    @GET("m_session_list")
    Call<ApiResponse> listSessionsData();

    @GET("m_delete_assigned_kart/{session_id}/{s_user_id}/{s_kart_id}")
    Call<ApiResponse> deleteSession(
            @Path("session_id") String session_id,
            @Path("s_user_id") String s_user_id,
            @Path("s_kart_id") String s_kart_id);

    @POST("m_start_session")
    Call<ApiResponse> sessionList(@Body StartSessionData body);
*/
}