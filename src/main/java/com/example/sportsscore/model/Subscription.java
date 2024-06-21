package com.example.sportsscore.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriptionId;

    @ManyToOne
    @JoinColumn(name = "id")
    private User subscriber;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private SubscriptionType subscriptionType;

    private String detailValue;


    // Default constructor
    public Subscription() {}

    // Parameterized constructor
    public Subscription(int subscriptionId, User subscriber, SubscriptionType subscriptionType, String detailValue) {
        this.subscriptionId = subscriptionId;
        this.subscriber = subscriber;
        this.subscriptionType = subscriptionType;
        this.detailValue = detailValue;
    }

    // Getters and setters
    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public User getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(User subscriber) {
        this.subscriber = subscriber;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getDetailValue() {
        return detailValue;
    }

    public void setDetailValue(String detailValue) {
        this.detailValue = detailValue;
    }
}
