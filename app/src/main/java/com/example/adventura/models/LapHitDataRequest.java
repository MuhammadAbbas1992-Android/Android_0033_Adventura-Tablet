package com.example.adventura.models;

import java.io.Serializable;

public class LapHitDataRequest implements Serializable{
    private String data;
    private String kartid;

    public LapHitDataRequest(String data, String kartid) {
        this.data = data;
        this.kartid = kartid;
    }
}

