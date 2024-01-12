package com.example.adventura.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPref {
    private static SharedPreferences mSharedPref;
    private static Gson gson;
    public static final String KEY_TOKEN = "Token";
    public static final String KEY_USERDATA = "KartsData";


    private SharedPref() {
    }

    public static void init(Context context) {
        gson = new Gson();

        if (mSharedPref == null)
            mSharedPref = context.getSharedPreferences("MySeprateSharedPref", Activity.MODE_PRIVATE);

    }

    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.commit();
    }

    public static float read(String key, float defValue) {
        return mSharedPref.getFloat(key, defValue);
    }

    public static void write(String key, float value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putFloat(key, value);
        prefsEditor.commit();
    }
}
