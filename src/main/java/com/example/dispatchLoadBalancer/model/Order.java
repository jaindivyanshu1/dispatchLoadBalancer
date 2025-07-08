package com.example.dispatchLoadBalancer.model;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    private String orderId;

    private Double latitude;
    private Double longitude;
    private String address;
    private Double packageWeight;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    public Order(){}

    public Order(
            String orderId,
            Double latitude,
            Double longitude,
            String address,
            Double packageWeight,
            Priority priority
    ){
        this.orderId = orderId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.packageWeight = packageWeight;
        this.priority = priority;
    }

    //order
    public String getOrderId(){
        return orderId;
    }
    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    //latitude
    public Double getLatitude(){
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    //longitude
    public Double getLongitude(){
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    //address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    //packageWeight
    public Double getPackageWeight() {
        return packageWeight;
    }
    public void setPackageWeight(Double packageWeight) {
        this.packageWeight = packageWeight;
    }

    //priority
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority){
        this.priority = priority;
    }

}
