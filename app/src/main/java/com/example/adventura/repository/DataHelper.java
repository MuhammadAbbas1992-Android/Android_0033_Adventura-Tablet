package com.example.adventura.repository;

import android.util.Log;

import com.example.adventura.listeners.UserLoginDataListener;
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
                Log.d("Abc After",apiResponse+"");
                //Extract UserTokenData from ApiResponse Class
                /*Gson gson=new Gson();
                String jsonString=gson.toJson(apiResponse.getData());
                UserTokenData userTokenData =gson.fromJson(jsonString, UserTokenData.class);*/

                userLoginDataListener.onUsersLoginDataLoaded(null);
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                userLoginDataListener.onUsersLoginDataLoadFailed(t.getMessage());
            }
        });
    }
    /*public static void getKartsData(KartsDataListener kartsDataListener)
    {
        Call<ApiResponse> call= Service.getInstance().getMyApi().listKartsData();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();

                Gson gson = new Gson();
                String jsonString = gson.toJson(apiResponse.getData());

                // Use Gson to deserialize the JSON data into a list of Kart objects
                Type kartListType = new TypeToken<List<KartsData>>() {}.getType();
                List<KartsData> kartsDataList = new Gson().fromJson(jsonString, kartListType);

                kartsDataListener.onKartsDataLoaded(kartsDataList);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                kartsDataListener.onKartsDataLoadFailed(t.getMessage());
            }
        });
    }
    public static void getKartsActivationStatus(String kart_id, String kart_assign_status, KartsActivationStatusDataListener kartsActivationStatusDataListener)
    {
        Call<ApiResponse> call;
        if (kart_assign_status.equals("1"))
        {
            call=Service.getInstance().getMyApi().kartActivateData(kart_id);
        }
        else
        {
            call=Service.getInstance().getMyApi().kartDeactivateData(kart_id);
        }

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                ApiResponse apiResponse=response.body();
                kartsActivationStatusDataListener.onKartActiveStatusDataLoaded(apiResponse.getData().toString());
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

                kartsActivationStatusDataListener.onKartActiveStatusDataLoadFailed(t.getMessage());
            }
        });
    }
    public static void sendScannedQRCustomersData(CustomerData customerData, QRCodeScannerDataListener qrCodeScannerDataListener)
    {

        Call<ApiResponse> call= Service.getInstance().getMyApi().scannedQRCustomersData(customerData);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();

                //Extract QRCodeScanner Response from ApiResponse Class
                Gson gson=new Gson();
                String jsonString=gson.toJson(apiResponse.getData());

                qrCodeScannerDataListener.onQRCodeScannerDataLoaded(jsonString);
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                qrCodeScannerDataListener.onQRCodeScannerDataFailed(t.getMessage());
            }
        });
    }
    public static void getSessionsData(SessionsDataListener sessionsDataListener)
    {
        Call<ApiResponse> call= Service.getInstance().getMyApi().listSessionsData();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();
//                Log.d("Session Data List: \n",apiResponse+"");
                Gson gson = new Gson();
                String jsonString = gson.toJson(apiResponse.getData());

                // Use Gson to deserialize the JSON data into a list of Kart objects
                Type sessionListType = new TypeToken<List<SessionData>>() {}.getType();
                List<SessionData> sessionDataList = new Gson().fromJson(jsonString, sessionListType);

                sessionsDataListener.onSessionsDataLoaded(sessionDataList);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                sessionsDataListener.onSessionsDataLoadFailed(t.getMessage());
            }
        });
    }
    public static void startSessionList(StartSessionData startSessionData, StartSessionListener startSessionListener)
    {
        Call<ApiResponse> call= Service.getInstance().getMyApi().sessionList(startSessionData);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                ApiResponse apiResponse=response.body();
                startSessionListener.onStartSessionLoaded(apiResponse.getData().toString());
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

                startSessionListener.onStartSessionLoadFailed(t.getMessage());
            }
        });
    }

    public static void deleteSessionData(String session_id,String s_user_id,String s_kart_id, DeleteSessionListener deleteSessionListener)
    {
        Call<ApiResponse> call= Service.getInstance().getMyApi().deleteSession(session_id,s_user_id,s_kart_id);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse=response.body();
                deleteSessionListener.onDeleteSessionLoaded(apiResponse.getData().toString());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                deleteSessionListener.onDeleteSessionLoadFailed(t.getMessage());
            }
        });
    }*/
}
