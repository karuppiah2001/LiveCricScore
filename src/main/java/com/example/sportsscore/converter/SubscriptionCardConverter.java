package com.example.sportsscore.converter;

import com.example.sportsscore.model.SubscriptionCard;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class SubscriptionCardConverter implements Converter<Object[], SubscriptionCard> {

    @Override
    public SubscriptionCard convert(Object[] source) {
        String mail = (String) source[0];
        String userName = (String) source[1];
        int typeId = (Integer) source[2];
        String detailValue = (String) source[3];
        String matchId = (String) source[4];
        LocalDateTime startTime = ((Timestamp) source[5]).toLocalDateTime();

        return new SubscriptionCard(mail, userName, typeId, detailValue, matchId, startTime);
    }
}
