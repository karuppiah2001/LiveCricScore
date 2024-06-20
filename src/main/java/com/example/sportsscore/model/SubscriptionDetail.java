package com.example.sportsscore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubscriptionDetail {
    @Id
    private int detailId;

    @ManyToOne
    @JoinColumn(name = "subscriptionId")
    private Subscription subscription;

    private String detailValue;

    // Default constructor
    public SubscriptionDetail() {}

    // Parameterized constructor
    public SubscriptionDetail(int detailId, Subscription subscription, String detailValue) {
        this.detailId = detailId;
        this.subscription = subscription;
        this.detailValue = detailValue;
    }

    // Getters and setters
    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public String getDetailValue() {
        return detailValue;
    }

    public void setDetailValue(String detailValue) {
        this.detailValue = detailValue;
    }
}
