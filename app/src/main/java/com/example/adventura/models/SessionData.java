package com.example.adventura.models;

import java.io.Serializable;

public class SessionData implements Serializable {

    private String s_user_id;
    private String s_kart_id;
    private String s_laps;
    private String completed_laps;
    private String s_qr_id;
    private String name;
    private String age;
    private String mobile_no;
    private String session_id;
    private String s_status;
    private String final_s_status;

    public SessionData() {
    }

    public String getS_user_id() {
        return s_user_id;
    }

    public void setS_user_id(String s_user_id) {
        this.s_user_id = s_user_id;
    }

    public String getS_kart_id() {
        return s_kart_id;
    }

    public void setS_kart_id(String s_kart_id) {
        this.s_kart_id = s_kart_id;
    }

    public String getS_laps() {
        return s_laps;
    }

    public void setS_laps(String s_laps) {
        this.s_laps = s_laps;
    }

    public String getCompleted_laps() {
        return completed_laps;
    }

    public void setCompleted_laps(String completed_laps) {
        this.completed_laps = completed_laps;
    }

    public String getS_qr_id() {
        return s_qr_id;
    }

    public void setS_qr_id(String s_qr_id) {
        this.s_qr_id = s_qr_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getS_status() {
        return s_status;
    }

    public void setS_status(String s_status) {
        this.s_status = s_status;
    }

    public String getFinal_s_status() {
        return final_s_status;
    }

    public void setFinal_s_status(String final_s_status) {
        this.final_s_status = final_s_status;
    }
}

