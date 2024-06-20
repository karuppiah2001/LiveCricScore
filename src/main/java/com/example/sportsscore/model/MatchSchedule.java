package com.example.sportsscore.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MatchSchedule")
public class MatchSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String team1;
    private String team2;
    private String matchId;
    private LocalDateTime startTime;

    public MatchSchedule(int id,String team1, String team2, String matchId, LocalDateTime startTime) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchId = matchId;
        this.startTime = startTime;
        this.id = id;
    }

    public MatchSchedule(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
