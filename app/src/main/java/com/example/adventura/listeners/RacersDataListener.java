package com.example.adventura.listeners;

import com.example.adventura.models.RacersData;

import java.util.List;

public interface RacersDataListener {
    void onRacersDataLoaded(List<RacersData> racersDataList);
    void onRacersDataLoadFailed(String exception);
}
