package com.example.sportsscore.repository;

import com.example.sportsscore.model.MatchSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchScheduleRepo extends JpaRepository<MatchSchedule,Integer> {

}
