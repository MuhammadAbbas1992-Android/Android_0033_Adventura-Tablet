package com.example.adventura.models;

import java.io.Serializable;
import java.util.Map;

public class RacersData implements Serializable {
    private String kart_no;
    private String username;
    private String type;
    private String capacity;
    private String cc;
    private String total_laps;
    private String completed_laps;
    private String total_lap_time;
    private Map<String, String> s_laps_time;

    public RacersData() {
    }

    public String getKart_no() {
        return kart_no;
    }

    public void setKart_no(String kart_no) {
        this.kart_no = kart_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getTotal_laps() {
        return total_laps;
    }

    public void setTotal_laps(String total_laps) {
        this.total_laps = total_laps;
    }

    public String getCompleted_laps() {
        return completed_laps;
    }

    public void setCompleted_laps(String completed_laps) {
        this.completed_laps = completed_laps;
    }

    public String getTotal_lap_time() {
        return total_lap_time;
    }

    public void setTotal_lap_time(String total_lap_time) {
        this.total_lap_time = total_lap_time;
    }

    public Map<String, String> getS_laps_time() {
        return s_laps_time;
    }

    public void setS_laps_time(Map<String, String> s_laps_time) {
        this.s_laps_time = s_laps_time;
    }
}
