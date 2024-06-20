package com.example.sportsscore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubscriptionType {
    @Id
    private int typeId;
    private String typeName;

    // Default constructor
    public SubscriptionType() {}

    // Parameterized constructor
    public SubscriptionType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    // Getters and setters
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
