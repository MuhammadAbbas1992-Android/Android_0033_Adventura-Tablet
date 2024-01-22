package com.example.adventura.repository;

import com.example.adventura.app.SharedPref;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static Service instance = null;
    private Api api;
    private Service() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // Add Authorization header to all requests
        httpClient.addInterceptor(chain -> {
            okhttp3.Request original = chain.request();
            okhttp3.Request.Builder requestBuilder = original.newBuilder()
                    .header("Authorization", SharedPref.read(SharedPref.KEY_TOKEN, "8a8bfdc798eef17a6138a77fadd6325e"));
            okhttp3.Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        // Add logging interceptor for debugging
       /* HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(loggingInterceptor);*/

        Retrofit retrofit = new Retrofit.Builder().baseUrl(SharedPref.read(SharedPref.KEY_BASE_API, "https://wallofjobs.com/"))
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        api = retrofit.create(Api.class);
    }
    public static synchronized Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public Api getMyApi() {
        return api;
    }

    public static void removeInstance() {
        instance = null;
    }
}
