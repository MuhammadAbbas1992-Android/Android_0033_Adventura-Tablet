package com.example.adventura.listeners;

import com.example.adventura.models.LapHitDataResponse;
import com.example.adventura.models.RacersData;

import java.util.List;

public interface LapHitDataListener {
    void onLapHitDataLoaded(LapHitDataResponse lapHitDataResponses);
    void onLapHitDataLoadFailed(String exception);
}
