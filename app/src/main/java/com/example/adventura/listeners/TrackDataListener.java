package com.example.adventura.listeners;

import com.example.adventura.models.TrackData;

import java.util.List;

public interface TrackDataListener {
    void onTrackDataLoaded(List<TrackData> trackDataList);
    void onTrackDataLoadFailed(String exception);
}
