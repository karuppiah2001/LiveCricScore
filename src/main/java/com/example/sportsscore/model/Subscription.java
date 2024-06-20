package com.example.sportsscore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subscription {
    @Id
    private int subscriptionId;

    @ManyToOne
    @JoinColumn(name = "id")
    private User subscriber;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private SubscriptionType subscriptionType;

    // Default constructor
    public Subscription() {}

    // Parameterized constructor
    public Subscription(int subscriptionId, User subscriber, SubscriptionType subscriptionType) {
        this.subscriptionId = subscriptionId;
        this.subscriber = subscriber;
        this.subscriptionType = subscriptionType;
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
}
