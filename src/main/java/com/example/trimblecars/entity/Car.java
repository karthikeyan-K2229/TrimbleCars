package com.example.trimblecars.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String status; // "AVAILABLE", "ON_LEASE", "UNDER_SERVICE"
    private String ownerId;
    // Getters and Setters

    public Car(Long id, String model, String status, String ownerId) {
        this.id = id;
        this.model = model;
        this.status = status;
        this.ownerId = ownerId;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}

