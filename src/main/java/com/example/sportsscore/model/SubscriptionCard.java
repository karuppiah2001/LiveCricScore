package com.example.sportsscore.model;

import java.time.LocalDateTime;

public class SubscriptionCard {
    private String mail;
    private String user_name;


    private String detail_value;
    private int type_id;
    private String matchId;
    private LocalDateTime start_time;

    public SubscriptionCard(){

    }

    public SubscriptionCard(String mail, String userName, int typeId,String detail_value, String matchId, LocalDateTime startTime) {
        this.mail = mail;
        this.user_name = userName;
        this.type_id = typeId;
        this.matchId = matchId;
        this.start_time = startTime;
        this.detail_value = detail_value;
    }


    public String getDetail_value() {
        return detail_value;
    }

    public void setDetail_value(String detail_value) {
        this.detail_value = detail_value;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }
}
