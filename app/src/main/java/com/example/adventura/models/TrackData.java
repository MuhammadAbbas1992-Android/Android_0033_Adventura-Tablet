package com.example.adventura.models;

import java.io.Serializable;
import java.util.Map;

public class TrackData implements Serializable {
    private String kart_id;
    private String kart_type;
    private String kart_no;
    private String kart_capacity;
    private String kart_cc;
    private String kart_status;
    private String added_date;
    private String updated_date;
    private String status;
    private String assign_status;
    private String onfly_status;
    private String assigned_user_id;
    private String current_session_id;
    private String id;
    private String name;
    private String age;
    private String mobile_no;
    private String dob;
    private String email;
    private String address;
    private String gender;
    private String artist_id;
    private String image;
    private String created_at;
    private String updated_at;
    private String user_kart_status;
    private String s_user_id;
    private String s_kart_id;
    private String s_laps;
    private String s_status;
    private String final_s_status;
    private String completed_laps;
    private Map<String, String> s_laps_time;
    private String best_lap_time;
    private String total_lap_time;
    private String s_qr_id;
    private String s_message;

    public TrackData(String kart_id, String kart_type, String kart_no, String kart_capacity,
                     String kart_cc, String kart_status, String added_date, String updated_date,
                     String status, String assign_status, String onfly_status, String assigned_user_id,
                     String current_session_id, String id, String name, String age, String mobile_no,
                     String dob, String email, String address, String gender, String artist_id,
                     String image, String created_at, String updated_at, String user_kart_status,
                     String s_user_id, String s_kart_id, String s_laps, String s_status,
                     String final_s_status, String completed_laps, Map<String, String> s_laps_time,
                     String best_lap_time, String total_lap_time, String s_qr_id, String s_message) {

        this.kart_id = kart_id;
        this.kart_type = kart_type;
        this.kart_no = kart_no;
        this.kart_capacity = kart_capacity;
        this.kart_cc = kart_cc;
        this.kart_status = kart_status;
        this.added_date = added_date;
        this.updated_date = updated_date;
        this.status = status;
        this.assign_status = assign_status;
        this.onfly_status = onfly_status;
        this.assigned_user_id = assigned_user_id;
        this.current_session_id = current_session_id;
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile_no = mobile_no;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.artist_id = artist_id;
        this.image = image;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_kart_status = user_kart_status;
        this.s_user_id = s_user_id;
        this.s_kart_id = s_kart_id;
        this.s_laps = s_laps;
        this.s_status = s_status;
        this.final_s_status = final_s_status;
        this.completed_laps = completed_laps;
        this.s_laps_time = s_laps_time;
        this.best_lap_time = best_lap_time;
        this.total_lap_time = total_lap_time;
        this.s_qr_id = s_qr_id;
        this.s_message = s_message;
    }
}
