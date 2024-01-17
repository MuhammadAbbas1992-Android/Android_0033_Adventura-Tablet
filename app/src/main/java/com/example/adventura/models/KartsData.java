package com.example.adventura.models;

import java.io.Serializable;
public class KartsData implements Serializable {
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
    private String assigned_user_id;
    private String current_session_id;

    public KartsData() {
    }

    public String getKart_id() {
        return kart_id;
    }

    public void setKart_id(String kart_id) {
        this.kart_id = kart_id;
    }

    public String getKart_type() {
        return kart_type;
    }

    public void setKart_type(String kart_type) {
        this.kart_type = kart_type;
    }

    public String getKart_no() {
        return kart_no;
    }

    public void setKart_no(String kart_no) {
        this.kart_no = kart_no;
    }

    public String getKart_capacity() {
        return kart_capacity;
    }

    public void setKart_capacity(String kart_capacity) {
        this.kart_capacity = kart_capacity;
    }

    public String getKart_cc() {
        return kart_cc;
    }

    public void setKart_cc(String kart_cc) {
        this.kart_cc = kart_cc;
    }

    public String getKart_status() {
        return kart_status;
    }

    public void setKart_status(String kart_status) {
        this.kart_status = kart_status;
    }

    public String getAdded_date() {
        return added_date;
    }

    public void setAdded_date(String added_date) {
        this.added_date = added_date;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssign_status() {
        return assign_status;
    }

    public void setAssign_status(String assign_status) {
        this.assign_status = assign_status;
    }

    public String getAssigned_user_id() {
        return assigned_user_id;
    }

    public void setAssigned_user_id(String assigned_user_id) {
        this.assigned_user_id = assigned_user_id;
    }

    public String getCurrent_session_id() {
        return current_session_id;
    }

    public void setCurrent_session_id(String current_session_id) {
        this.current_session_id = current_session_id;
    }
}
