package com.example.sportsscore.repository;

import com.example.sportsscore.model.Subscription;
import com.example.sportsscore.model.SubscriptionCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    @Query(value = "SELECT A.mail, A.user_name, B.type_id, B.detail_value, C.match_id, C.start_time\n" +
            "FROM subscribers A\n" +
            "INNER JOIN subscription B ON A.id = B.id\n" +
            "INNER JOIN match_schedule C ON (B.detail_value = C.team1 OR B.detail_value = C.team2) ",nativeQuery = true)
    public List<Object[]> getSubscriptionCards();


}
