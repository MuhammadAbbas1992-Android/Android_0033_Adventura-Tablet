package com.example.adventura.utils;

import com.example.adventura.models.RacersData;
import com.example.adventura.models.TrackData;

import java.util.ArrayList;
import java.util.List;

public class HelperUtils {
    public static List<TrackData> trackDataList=new ArrayList<>();
    public static List<RacersData> racersDataList=new ArrayList<>();
    public static String s_laps_time =  "{\"s_laps_time\":{\"lap_0\":\"2024-01-22 18:54:04\",\"lap_1\":\"2024-01-22 19:10:45\",\"lap_2\":\"2024-01-22 19:10:52\"}}";
//    public static String s_laps_time = "{\"lap_0\":\"2024-01-22 00:00:29\",\"lap_1\":\"2024-01-22 00:42:38\",\"lap_2\":\"2024-01-22 00:46:54\",\"lap_3\":\"2024-01-22 00:47:00\",\"lap_4\":\"2024-01-22 00:47:12\",\"lap_5\":\"2024-01-22 00:47:20\"}";

    public static List<String> lapNoList=new ArrayList<>();
    public static List<String> lapTimeList=new ArrayList<>();
}