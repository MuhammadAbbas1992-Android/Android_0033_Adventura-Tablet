package com.example.adventura.repository;

import android.util.Log;

import com.example.adventura.listeners.LapHitDataListener;
import com.example.adventura.listeners.RacersDataListener;
import com.example.adventura.listeners.TrackDataListener;
import com.example.adventura.listeners.UserLoginDataListener;
import com.example.adventura.models.LapHitDataRequest;
import com.example.adventura.models.LapHitDataResponse;
import com.example.adventura.models.RacersData;
import com.example.adventura.models.TrackData;
import com.example.adventura.models.UserLoginData;
import com.example.adventura.models.UserTokenData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataHelper {
    public static void sendUserLoginData(UserLoginData userLoginData, UserLoginDataListener userLoginDataListener)
    {
        Call<ApiResponse> call= Service.getInstance().getMyApi().userLoginData(userLoginData);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                ApiResponse apiResponse = response.body();

                //Extract UserTokenData from ApiResponse Class
                Gson gson=new Gson();
                String jsonString=gson.toJson(apiResponse.getData());
                UserTokenData userTokenData =gson.fromJson(jsonString, UserTokenData.class);

                userLoginDataListener.onUsersLoginDataLoaded(userTokenData);
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                userLoginDataListener.onUsersLoginDataLoadFailed(t.getMessage());
            }
        });
    }
    public static void getTrackData(TrackDataListener kartsDataListener)
    {
        Call<ApiResponse> call= Service.getInstance().getMyApi().listTrackData();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();

                Gson gson = new Gson();
                String jsonString = gson.toJson(apiResponse.getData());

                // Use Gson to deserialize the JSON data into a list of Track objects
                Type trackListType = new TypeToken<List<TrackData>>() {}.getType();
                List<TrackData> kartsDataList = new Gson().fromJson(jsonString, trackListType);

                kartsDataListener.onTrackDataLoaded(kartsDataList);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                kartsDataListener.onTrackDataLoadFailed(t.getMessage());
            }
        });
    }
    public static void sendLapHitsCountData(LapHitDataRequest lapHitDataRequest, LapHitDataListener lapHitDataListener)
    {

        Call<ApiResponse> call= Service.getInstance().getMyApi().lapCountingData(lapHitDataRequest);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();
//                //Extract QRCodeScanner Response from ApiResponse Class
                Gson gson=new Gson();
                String jsonString=gson.toJson(apiResponse.getData());
                LapHitDataResponse lapHitDataResponse =gson.fromJson(jsonString, LapHitDataResponse.class);

                lapHitDataListener.onLapHitDataLoaded(lapHitDataResponse);
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                lapHitDataListener.onLapHitDataLoadFailed(t.getMessage());
            }
        });
    }
    public static void getRacersData(RacersDataListener racersDataListener)
    {

        Call<ApiResponse> call= Service.getInstance().getMyApi().listRacersData();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();

                Gson gson = new Gson();
                String jsonString = gson.toJson(apiResponse.getData());

                // Use Gson to deserialize the JSON data into a list of Kart objects
                Type racersListType = new TypeToken<List<RacersData>>() {}.getType();
                List<RacersData> racersDataList = new Gson().fromJson(jsonString, racersListType);

                racersDataListener.onRacersDataLoaded(racersDataList);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                racersDataListener.onRacersDataLoadFailed(t.getMessage());
            }
        });
    }

}
