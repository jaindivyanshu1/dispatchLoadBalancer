package com.example.dispatchLoadBalancer.dto;

public class OrderDTO {

    private String orderId;
    private Double latitude;
    private Double longitude;
    private String address;
    private Double packageWeight;
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

