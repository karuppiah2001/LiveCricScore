package com.example.sportsscore.repository;

import com.example.sportsscore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<User, Integer> {}
