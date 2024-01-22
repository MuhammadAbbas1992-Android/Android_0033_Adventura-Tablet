package com.example.adventura.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class LapTimesData {

    @SerializedName("s_laps_time")
    private Map<String, String> sLapsTime;

    public Map<String, String> getsLapsTime() {
        return sLapsTime;
    }

    public void setsLapsTime(Map<String, String> sLapsTime) {
        this.sLapsTime = sLapsTime;
    }
}
