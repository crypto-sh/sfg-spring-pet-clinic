package com.springframework.model;

public class Specialty extends BaseEntity {

    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
