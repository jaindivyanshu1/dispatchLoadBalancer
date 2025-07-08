package com.example.dispatchLoadBalancer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    private String vehicleId;

    private Double capacity;
    private Double currentLatitude;
    private Double currentLongitude;
    private String currentAddress;

    public Vehicle(){}

    public Vehicle(
            String vehicleId,
            Double capacity,
            Double currentLatitude,
            Double currentLongitude,
            String currentAddress
    ) {
        this.vehicleId = vehicleId;
        this.capacity = capacity;
        this.currentAddress = currentAddress;
        this.currentLatitude = currentLatitude;
        this.currentLongitude = currentLongitude;
    }


    //vehicleId
    public String getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    //capacity
    public Double getCapacity() {
        return capacity;
    }
    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    //currentLatitude
    public Double getCurrentLatitude() {
        return currentLatitude;
    }
    public void setCurrentLatitude(Double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    //currentLongitude
    public Double getCurrentLongitude() {
        return currentLongitude;
    }
    public void setCurrentLongitude(Double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    //currentAddress
    public String getCurrentAddress() {
        return currentAddress;
    }
    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }


}
