package com.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class RatingCategory {

    @Id
    private String category;
    private double standardPercentage;

    // Getters and Setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getStandardPercentage() {
        return standardPercentage;
    }

    public void setStandardPercentage(double standardPercentage) {
        this.standardPercentage = standardPercentage;
    }
}