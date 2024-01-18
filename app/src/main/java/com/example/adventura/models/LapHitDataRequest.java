package com.example.adventura.models;

import java.io.Serializable;

public class LapHitDataRequest implements Serializable {
    private String data;
    private String kartid;

    // Default constructor is needed for deserialization
    public LapHitDataRequest() {
    }

    public LapHitDataRequest(String data, String kartid) {
        this.data = data;
        this.kartid = kartid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getKartid() {
        return kartid;
    }

    public void setKartid(String kartid) {
        this.kartid = kartid;
    }
}

