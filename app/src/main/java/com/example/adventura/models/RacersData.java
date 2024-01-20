package com.example.adventura.models;

import java.io.Serializable;

public class RacersData implements Serializable {
    private Object data;
    public RacersData() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
