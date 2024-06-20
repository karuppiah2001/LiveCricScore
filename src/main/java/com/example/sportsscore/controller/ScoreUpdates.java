package com.example.sportsscore.controller;

import com.example.sportsscore.model.MatchSchedule;
import com.example.sportsscore.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreUpdates {


    @Autowired
    MatchService matchService;

    @GetMapping("recentMatches")
    public List<MatchSchedule> getRecentMatches(){
       return matchService.getTodayMatchList();
    }


}
