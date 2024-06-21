package com.example.sportsscore.service;

import com.example.sportsscore.converter.SubscriptionCardConverter;
import com.example.sportsscore.model.MatchSchedule;
import com.example.sportsscore.model.Subscription;
import com.example.sportsscore.model.SubscriptionCard;
import com.example.sportsscore.repository.MatchScheduleRepo;
import com.example.sportsscore.repository.SubscriptionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Autowired
    private HttpRequest.Builder requestBuilder;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    MatchScheduleRepo matchScheduleRepo;

    @Autowired
    SubscriptionCardConverter subscriptionCardConverter;

    public List<MatchSchedule> getTodayMatchList(){

        HttpResponse<String> response = null;
        HttpRequest request = requestBuilder.uri(URI.create("https://cricbuzz-cricket.p.rapidapi.com/schedule/v1/international"))
                .build();

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException ioe){
            System.out.println("IO/I exp");
            return null;
        }

        List<MatchSchedule> matchScheduleList = extractTodayMatches(response.body());
        // save all to db
        // delete before save
        matchScheduleRepo.deleteAll();
        for (MatchSchedule matchSchedule : matchScheduleList){
            matchScheduleRepo.save(matchSchedule);
        }

        return matchScheduleList;
    }

    List<MatchSchedule> extractTodayMatches(String repsonse){
        List<MatchSchedule> todaymatches = new ArrayList<>();

        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode obj = mapper.readTree(repsonse);

            JsonNode matchScheduleMap = obj.get("matchScheduleMap");
            for(JsonNode schedule : matchScheduleMap){
                if(schedule != null){
                    JsonNode scheduleAdWrapper = schedule.get("scheduleAdWrapper");
                    if(scheduleAdWrapper == null){
                        continue;
                    }
                    String date = scheduleAdWrapper.get("date").asText();

                    if(isMatchToday(date)){
                        for(JsonNode matchSchedule : scheduleAdWrapper.get("matchScheduleList")){
                            if(matchSchedule != null){
                                for(JsonNode match : matchSchedule.get("matchInfo")){
                                    String matchId = match.get("matchId").asText();
                                    LocalDateTime startTime = convertEpochToDateTime(match.get("startDate").asText());

                                    String team1 = match.get("team1").get("teamSName").asText();
                                    String team2 = match.get("team2").get("teamSName").asText();

                                    // add to list
                                    MatchSchedule todayMatch = new MatchSchedule(0,team1,team2,matchId,startTime);
                                    todaymatches.add(todayMatch);
                                }
                            }
                        }
                    }
                }
            }

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return todaymatches;
    }

    private LocalDateTime convertEpochToDateTime(String epoch){
        long epochMilli = Long.parseLong(epoch); // Example epoch time in milliseconds (June 13, 2024 12:00:00 AM UTC)

        // Convert epoch to Instant object
        Instant instant = Instant.ofEpochMilli(epochMilli);

        // Specify a time zone (optional, defaults to system zone)
        ZoneId zoneId = ZoneId.of("Asia/Kolkata"); // Example time zone

        // Convert Instant to LocalDateTime in the specified zone
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime;
    }
    private  boolean isMatchToday(String date) {
        String[] splitedDate = date.substring(5).split(" ");
        if(LocalDate.now().getDayOfMonth() == Integer.parseInt(splitedDate[1])){
            return true;
        }
        return false;
    }


    public List<SubscriptionCard> getMatchAndSubscriber(){
        List<Object[]> subscriptionCards = subscriptionRepository.getSubscriptionCards();


        return subscriptionCards.stream()
                .map(subscriptionCardConverter::convert)
                .collect(Collectors.toList());
    }
}
