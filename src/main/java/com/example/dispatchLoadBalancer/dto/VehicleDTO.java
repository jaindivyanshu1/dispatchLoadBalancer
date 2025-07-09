package com.example.dispatchLoadBalancer.dto;

import jakarta.validation.constraints.*;

public class VehicleDTO {

    @NotBlank(message = "Vehicle ID is required")
    private String vehicleId;

    @NotNull(message = "Capacity is required")
    @Positive(message = "Capacity must be greater than zero")
    private Double capacity;

    @NotNull(message = "Current latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be >= -90")
    @DecimalMax(value = "90.0", message = "Latitude must be <= 90")
    private Double currentLatitude;

    @NotNull(message = "Current longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be >= -180")
    @DecimalMax(value = "180.0", message = "Longitude must be <= 180")
    private Double currentLongitude;

    @NotBlank(message = "Current address is required")
    private String currentAddress;

    public VehicleDTO(){}

    public VehicleDTO(
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
