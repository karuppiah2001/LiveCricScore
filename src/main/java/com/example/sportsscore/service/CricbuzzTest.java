package com.example.sportsscore.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class CricbuzzTest {








    public static void main(String[] args) {
        String resp = "{\"matchScheduleMap\":[{\"scheduleAdWrapper\":{\"date\":\"WED, JUN 19 2024\",\"matchScheduleList\":[{\"seriesName\":\"Estonia tour of Cyprus 2024\",\"matchInfo\":[{\"matchId\":96766,\"seriesId\":8310,\"matchDesc\":\"5th T20I\",\"matchFormat\":\"T20\",\"startDate\":\"1718775000000\",\"endDate\":\"1718841599000\",\"team1\":{\"teamId\":1111,\"teamName\":\"Cyprus\",\"teamSName\":\"CYP\",\"imageId\":247198},\"team2\":{\"teamId\":526,\"teamName\":\"Estonia\",\"teamSName\":\"EST\",\"imageId\":172576},\"venueInfo\":{\"ground\":\"Happy Valley Ground\",\"city\":\"Episkopi\",\"country\":\"Cyprus\",\"timezone\":\"+03:00\"}},{\"matchId\":96771,\"seriesId\":8310,\"matchDesc\":\"6th T20I\",\"matchFormat\":\"T20\",\"startDate\":\"1718788500000\",\"endDate\":\"1718841599000\",\"team1\":{\"teamId\":1111,\"teamName\":\"Cyprus\",\"teamSName\":\"CYP\",\"imageId\":247198},\"team2\":{\"teamId\":526,\"teamName\":\"Estonia\",\"teamSName\":\"EST\",\"imageId\":172576},\"venueInfo\":{\"ground\":\"Happy Valley Ground\",\"city\":\"Episkopi\",\"country\":\"Cyprus\",\"timezone\":\"+03:00\"}}],\"seriesId\":8310,\"seriesHomeCountry\":1,\"seriesCategory\":\"International\"},{\"seriesName\":\"ICC Mens T20 World Cup 2024\",\"matchInfo\":[{\"matchId\":87780,\"seriesId\":7476,\"matchDesc\":\"41st Match, Super 8 Group 2\",\"matchFormat\":\"T20\",\"startDate\":\"1718807400000\",\"endDate\":\"1718841599000\",\"team1\":{\"teamId\":15,\"teamName\":\"United States\",\"teamSName\":\"USA\",\"imageId\":172130},\"team2\":{\"teamId\":11,\"teamName\":\"South Africa\",\"teamSName\":\"RSA\",\"isFullMember\":true,\"imageId\":172126},\"venueInfo\":{\"ground\":\"Sir Vivian Richards Stadium\",\"city\":\"North Sound, Antigua\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}}],\"seriesId\":7476,\"seriesCategory\":\"International\"}],\"longDate\":\"1718755200000\"}},{\"adDetail\":{\"name\":\"native_news_index_random_1\",\"layout\":\"native_large\",\"position\":1}},{\"scheduleAdWrapper\":{\"date\":\"THU, JUN 20 2024\",\"matchScheduleList\":[{\"seriesName\":\"ICC Mens T20 World Cup 2024\",\"matchInfo\":[{\"matchId\":87794,\"seriesId\":7476,\"matchDesc\":\"43rd Match, Super 8 Group 1\",\"matchFormat\":\"T20\",\"startDate\":\"1718893800000\",\"endDate\":\"1718927999000\",\"team1\":{\"teamId\":96,\"teamName\":\"Afghanistan\",\"teamSName\":\"AFG\",\"isFullMember\":true,\"imageId\":172188},\"team2\":{\"teamId\":2,\"teamName\":\"India\",\"teamSName\":\"IND\",\"isFullMember\":true,\"imageId\":172115},\"venueInfo\":{\"ground\":\"Kensington Oval\",\"city\":\"Bridgetown, Barbados\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}},{\"matchId\":87787,\"seriesId\":7476,\"matchDesc\":\"42nd Match, Super 8 Group 2\",\"matchFormat\":\"T20\",\"startDate\":\"1718843400000\",\"endDate\":\"1718841599000\",\"team1\":{\"teamId\":9,\"teamName\":\"England\",\"teamSName\":\"ENG\",\"isFullMember\":true,\"imageId\":172123},\"team2\":{\"teamId\":10,\"teamName\":\"West Indies\",\"teamSName\":\"WI\",\"isFullMember\":true,\"imageId\":172124},\"venueInfo\":{\"ground\":\"Daren Sammy National Cricket Stadium\",\"city\":\"Gros Islet, St Lucia\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}}],\"seriesId\":7476,\"seriesCategory\":\"International\"}],\"longDate\":\"1718841600000\"}},{\"scheduleAdWrapper\":{\"date\":\"FRI, JUN 21 2024\",\"matchScheduleList\":[{\"seriesName\":\"ICC Mens T20 World Cup 2024\",\"matchInfo\":[{\"matchId\":87808,\"seriesId\":7476,\"matchDesc\":\"45th Match, Super 8 Group 2\",\"matchFormat\":\"T20\",\"startDate\":\"1718980200000\",\"endDate\":\"1719014399000\",\"team1\":{\"teamId\":9,\"teamName\":\"England\",\"teamSName\":\"ENG\",\"isFullMember\":true,\"imageId\":172123},\"team2\":{\"teamId\":11,\"teamName\":\"South Africa\",\"teamSName\":\"RSA\",\"isFullMember\":true,\"imageId\":172126},\"venueInfo\":{\"ground\":\"Daren Sammy National Cricket Stadium\",\"city\":\"Gros Islet, St Lucia\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}},{\"matchId\":87801,\"seriesId\":7476,\"matchDesc\":\"44th Match, Super 8 Group 1\",\"matchFormat\":\"T20\",\"startDate\":\"1718929800000\",\"endDate\":\"1718927999000\",\"team1\":{\"teamId\":4,\"teamName\":\"Australia\",\"teamSName\":\"AUS\",\"isFullMember\":true,\"imageId\":172117},\"team2\":{\"teamId\":6,\"teamName\":\"Bangladesh\",\"teamSName\":\"BAN\",\"isFullMember\":true,\"imageId\":172120},\"venueInfo\":{\"ground\":\"Sir Vivian Richards Stadium\",\"city\":\"North Sound, Antigua\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}}],\"seriesId\":7476,\"seriesCategory\":\"International\"}],\"longDate\":\"1718928000000\"}},{\"scheduleAdWrapper\":{\"date\":\"SAT, JUN 22 2024\",\"matchScheduleList\":[{\"seriesName\":\"ICC Mens T20 World Cup 2024\",\"matchInfo\":[{\"matchId\":87822,\"seriesId\":7476,\"matchDesc\":\"47th Match, Super 8 Group 1\",\"matchFormat\":\"T20\",\"startDate\":\"1719066600000\",\"endDate\":\"1719100799000\",\"team1\":{\"teamId\":2,\"teamName\":\"India\",\"teamSName\":\"IND\",\"isFullMember\":true,\"imageId\":172115},\"team2\":{\"teamId\":6,\"teamName\":\"Bangladesh\",\"teamSName\":\"BAN\",\"isFullMember\":true,\"imageId\":172120},\"venueInfo\":{\"ground\":\"Sir Vivian Richards Stadium\",\"city\":\"North Sound, Antigua\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}},{\"matchId\":87815,\"seriesId\":7476,\"matchDesc\":\"46th Match, Super 8 Group 2\",\"matchFormat\":\"T20\",\"startDate\":\"1719016200000\",\"endDate\":\"1719014399000\",\"team1\":{\"teamId\":15,\"teamName\":\"United States\",\"teamSName\":\"USA\",\"imageId\":172130},\"team2\":{\"teamId\":10,\"teamName\":\"West Indies\",\"teamSName\":\"WI\",\"isFullMember\":true,\"imageId\":172124},\"venueInfo\":{\"ground\":\"Kensington Oval\",\"city\":\"Bridgetown, Barbados\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}}],\"seriesId\":7476,\"seriesCategory\":\"International\"}],\"longDate\":\"1719014400000\"}},{\"adDetail\":{\"name\":\"native_news_index_random_2\",\"layout\":\"native_large\",\"position\":4}},{\"scheduleAdWrapper\":{\"date\":\"SUN, JUN 23 2024\",\"matchScheduleList\":[{\"seriesName\":\"ICC Mens T20 World Cup 2024\",\"matchInfo\":[{\"matchId\":87829,\"seriesId\":7476,\"matchDesc\":\"48th Match, Super 8 Group 1\",\"matchFormat\":\"T20\",\"startDate\":\"1719102600000\",\"endDate\":\"1719100799000\",\"team1\":{\"teamId\":96,\"teamName\":\"Afghanistan\",\"teamSName\":\"AFG\",\"isFullMember\":true,\"imageId\":172188},\"team2\":{\"teamId\":4,\"teamName\":\"Australia\",\"teamSName\":\"AUS\",\"isFullMember\":true,\"imageId\":172117},\"venueInfo\":{\"ground\":\"Arnos Vale Ground\",\"city\":\"Kingstown, St Vincent\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}},{\"matchId\":87836,\"seriesId\":7476,\"matchDesc\":\"49th Match, Super 8 Group 2\",\"matchFormat\":\"T20\",\"startDate\":\"1719153000000\",\"endDate\":\"1719187199000\",\"team1\":{\"teamId\":15,\"teamName\":\"United States\",\"teamSName\":\"USA\",\"imageId\":172130},\"team2\":{\"teamId\":9,\"teamName\":\"England\",\"teamSName\":\"ENG\",\"isFullMember\":true,\"imageId\":172123},\"venueInfo\":{\"ground\":\"Kensington Oval\",\"city\":\"Bridgetown, Barbados\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}}],\"seriesId\":7476,\"seriesCategory\":\"International\"}],\"longDate\":\"1719100800000\"}},{\"scheduleAdWrapper\":{\"date\":\"MON, JUN 24 2024\",\"matchScheduleList\":[{\"seriesName\":\"ICC Mens T20 World Cup 2024\",\"matchInfo\":[{\"matchId\":87843,\"seriesId\":7476,\"matchDesc\":\"50th Match, Super 8 Group 2\",\"matchFormat\":\"T20\",\"startDate\":\"1719189000000\",\"endDate\":\"1719187199000\",\"team1\":{\"teamId\":10,\"teamName\":\"West Indies\",\"teamSName\":\"WI\",\"isFullMember\":true,\"imageId\":172124},\"team2\":{\"teamId\":11,\"teamName\":\"South Africa\",\"teamSName\":\"RSA\",\"isFullMember\":true,\"imageId\":172126},\"venueInfo\":{\"ground\":\"Sir Vivian Richards Stadium\",\"city\":\"North Sound, Antigua\",\"country\":\"West Indies\",\"timezone\":\"-04:00\"}}],\"seriesId\":7476,\"seriesCategory\":\"International\"}],\"longDate\":\"1719187200000\"}}],\"startDt\":[\"1718807400000\",\"1718843400000\",\"1718775000000\",\"1718788500000\",\"1718893800000\",\"1718929800000\",\"1718980200000\",\"1719016200000\",\"1719066600000\",\"1719102600000\",\"1719153000000\",\"1719189000000\",\"1719239400000\",\"1719275400000\",\"1719448200000\",\"1719498600000\",\"1719556200000\",\"1719570600000\",\"1719669600000\",\"1719642600000\",\"1719657000000\",\"1719729000000\",\"1719743400000\",\"1719901800000\",\"1719916200000\",\"1719988200000\",\"1720002600000\",\"1720074600000\",\"1720089000000\",\"1720263600000\",\"1720247400000\",\"1720261800000\",\"1720350000000\",\"1720341000000\",\"1720341000000\",\"1720359000000\",\"1720359000000\",\"1720333800000\",\"1720348200000\",\"1720427400000\",\"1720427400000\",\"1720445400000\",\"1720445400000\",\"1720420200000\",\"1720434600000\",\"1720605600000\",\"1720609200000\",\"1720600200000\",\"1720587600000\",\"1720618200000\",\"1720618200000\",\"1720593000000\",\"1720607400000\",\"1720686600000\",\"1720686600000\",\"1720704600000\",\"1720704600000\",\"1720868400000\",\"1720859400000\",\"1720859400000\",\"1720877400000\",\"1720877400000\",\"1720954800000\",\"1720945800000\",\"1720945800000\",\"1720963800000\",\"1720963800000\",\"1721124000000\",\"1721296800000\",\"1721296800000\",\"1721469600000\",\"1721642400000\",\"1721815200000\",\"1721900700000\",\"1721988000000\",\"1721988000000\",\"1722238200000\",\"1722254400000\",\"1722324600000\",\"1722340800000\",\"1722411000000\",\"1722427200000\",\"1722434400000\",\"1723039200000\",\"1724234400000\",\"1724227200000\",\"1724245200000\",\"1724313600000\",\"1724331600000\",\"1724439600000\",\"1724526000000\",\"1724785200000\",\"1724925600000\",\"1725616800000\",\"1726075800000\",\"1726248600000\",\"1726421400000\",\"1726740000000\",\"1726923600000\",\"1727172000000\",\"1727442000000\",\"1727452800000\",\"1727604000000\",\"1727625600000\",\"1727848800000\",\"1728021600000\",\"1728280800000\",\"1730397600000\",\"1730554200000\",\"1730691000000\",\"1730916000000\",\"1731038400000\",\"1731182400000\",\"1731216600000\",\"1731268800000\",\"1731573000000\",\"1731614400000\",\"1731679200000\",\"1731744000000\",\"1731787200000\",\"1731873600000\",\"1731916800000\",\"1732242600000\",\"1732284000000\",\"1732692600000\",\"1732831200000\",\"1732975200000\",\"1733387400000\",\"1733457600000\",\"1733522400000\",\"1733664600000\",\"1733846400000\",\"1733837400000\",\"1734010200000\",\"1734105600000\",\"1734134400000\",\"1734213600000\",\"1734192000000\",\"1734307200000\",\"1734433200000\",\"1734480000000\",\"1734606000000\",\"1734652800000\",\"1734865200000\",\"1735171200000\",\"1735201800000\",\"1735862400000\",\"1735893000000\",\"1748426400000\"],\"appIndex\":{\"seoTitle\":\"Cricket Schedule - International, domestic and T20 matches - Cricbuzz\",\"webURL\":\"www.cricbuzz.com/cricket-schedule/series\"}}";

        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode obj = mapper.readTree(resp);

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
                                    LocalDateTime startDate = convertEpochToDateTime(match.get("startDate").asText());

                                    String team1 = match.get("team1").get("teamSName").asText();
                                    String team2 = match.get("team2").get("teamSName").asText();

                                    // store to db for today

                                    System.out.println(matchId +" "+startDate+" "+team1+" "+team2);

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

        }

    private static boolean isMatchToday(String date) {
        String[] splitedDate = date.substring(5).split(" ");
        if(LocalDate.now().getDayOfMonth() == Integer.parseInt(splitedDate[1])){
            return true;
        }
        return false;
    }



    void referMatch(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode obj = mapper.readTree("");
            JsonNode typeMatches = obj.get("typeMatches");

            for(int i = 0;i<typeMatches.size();i++){
                JsonNode matches = typeMatches.get(i);
                if(matches.get("matchType").asText().equals(MatchTypes.INTERNATIONAL.get())){
                    JsonNode series = matches.get("seriesMatches");

                    for(JsonNode node : series){
                        JsonNode currentSeries = node.get("seriesAdWrapper");
                        if(currentSeries != null){
                            System.out.println(currentSeries.get("seriesId"));
                            System.out.println(currentSeries.get("seriesName"));

                            JsonNode matcheList = currentSeries.get("matches");
                            for(JsonNode match : matcheList){
                                if(match != null){
                                    JsonNode matchInfo = match.get("matchInfo");

                                    String startDate = matchInfo.get("startDate").asText();
                                    LocalDateTime startDateTime = convertToTime(startDate);

                                    LocalDateTime today = LocalDateTime.now();
                                    if(startDateTime != null && today.getYear() == today.getYear() && today.getMonth() ==startDateTime.getMonth() && today.getDayOfMonth() == startDateTime.getDayOfMonth()){
                                        System.out.println(matchInfo.get("matchId"));
                                    }
                                }
                            }
                        }
                    }



                }
            }


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
    static LocalDateTime convertToTime(String ms){
        try {
            // Parse the string as a long (representing milliseconds since epoch)
            long timestamp = Long.parseLong(ms);

            // Convert the timestamp to an Instant
            Instant instant = Instant.ofEpochMilli(timestamp);

            // Convert the Instant to LocalDateTime in the system default time zone
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

            // Format the LocalDateTime to a readable string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);
            return LocalDateTime.parse(formattedDateTime,formatter);
        } catch (NumberFormatException e) {
            System.err.println("Invalid timestamp format: " + ms);
            e.printStackTrace();
        }

            return null;

    }

   static LocalDateTime convertEpochToDateTime(String epoch){
        long epochMilli = Long.parseLong(epoch); // Example epoch time in milliseconds (June 13, 2024 12:00:00 AM UTC)

        // Convert epoch to Instant object
        Instant instant = Instant.ofEpochMilli(epochMilli);

        // Specify a time zone (optional, defaults to system zone)
        ZoneId zoneId = ZoneId.of("Asia/Kolkata"); // Example time zone

        // Convert Instant to LocalDateTime in the specified zone
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime;
    }
}



enum MatchTypes{
    INTERNATIONAL,
    LEAGUE,
    WOMEN;

    public String get() {
        switch (this) {
            case INTERNATIONAL:
                return "International";
            case LEAGUE:
                return "League";
            case WOMEN:
                return "Women";
            default:
                throw new IllegalArgumentException("Unsupported match type: " + this);
        }
    }

}