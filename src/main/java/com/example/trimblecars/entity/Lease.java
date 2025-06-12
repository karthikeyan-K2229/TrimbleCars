package com.example.trimblecars.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Lease {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long carId;
    private Long customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Lease(Long id, Long carId, Long customerId, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Lease() {
    }
}
