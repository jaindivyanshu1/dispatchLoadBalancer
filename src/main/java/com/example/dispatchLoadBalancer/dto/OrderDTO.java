package com.example.dispatchLoadBalancer.dto;

import jakarta.validation.constraints.*;


public class OrderDTO {

    @NotBlank(message = "Order ID must not be blank")
    private String orderId;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be >= -90")
    @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be <= 90")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be >= -180")
    @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be <= 180")
    private Double longitude;

    @NotBlank(message = "Address must not be blank")
    private String address;

    @NotNull(message = "Package weight is required")
    @Positive(message = "Package weight must be a positive number")
    private Double packageWeight;

    @NotBlank(message = "Priority must not be blank")
    @Pattern(
            regexp = "LOW|MEDIUM|HIGH",
            message = "Priority must be one of: LOW, MEDIUM, HIGH"
    )
    private String priority;


    public OrderDTO() {
    }

    public OrderDTO(
            String orderId,
            Double latitude,
            Double longitude,
            String address,
            Double packageWeight,
            String priority
    ) {
        this.orderId = orderId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.packageWeight = packageWeight;
        this.priority = priority;
    }

    //orderId
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    //latitude
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    //longitude
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    //address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //packageWight
    public Double getPackageWeight() {
        return packageWeight;
    }
    public void setPackageWeight(Double packageWeight) {
        this.packageWeight = packageWeight;
    }

    //priority
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }

}

