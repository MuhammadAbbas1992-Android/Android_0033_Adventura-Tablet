package com.example.adventura.models;

import java.io.Serializable;

public class LapHitDataResponse implements Serializable {
    private int completedlaps;
    private String totallaps;
    private String lap_message;

    public LapHitDataResponse(int completedlaps, String totallaps, String lap_message) {
        this.completedlaps = completedlaps;
        this.totallaps = totallaps;
        this.lap_message = lap_message;
    }

    public int getCompletedlaps() {
        return completedlaps;
    }

    public String getTotallaps() {
        return totallaps;
    }

    public String getLap_message() {
        return lap_message;
    }
}
