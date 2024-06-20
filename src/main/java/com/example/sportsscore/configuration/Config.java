package com.example.sportsscore.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpRequest;

@Configuration
public class Config {

    @Value("${api.key}")
    String api_key;

    @Value("${api.host}")
    String api_host;

    @Bean
    public HttpRequest.Builder httpClient() {
        HttpRequest.Builder client = HttpRequest.newBuilder()
                .header("x-rapidapi-key", getApi_key())
                .header("x-rapidapi-host", getApi_host())
                .method("GET", HttpRequest.BodyPublishers.noBody());

        return client;
    }

    public String getApi_key() {
        return api_key;
    }

    public String getApi_host() {
        return api_host;
    }
}
