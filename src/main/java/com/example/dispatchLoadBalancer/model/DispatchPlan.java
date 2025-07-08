package com.example.dispatchLoadBalancer.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="dispatch_plans")
public class DispatchPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    private String vehicleId;
    private Double totalLoad;
    private Double totalDistance;

    @ManyToMany
    @JoinTable(
            name = "dispatch_plan_orders",
            joinColumns = @JoinColumn(name = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> assignedOrders;

    public DispatchPlan(){}

    public DispatchPlan(
            Long planId,
            String vehicleId,
            Double totalDistance,
            Double totalLoad,
            List<Order> assignedOrders
    ) {
        this.planId = planId;
        this.vehicleId = vehicleId;
        this.totalDistance = totalDistance;
        this.totalLoad = totalLoad;
        this.assignedOrders = assignedOrders;
    }

    //planId
    public Long getPlanId() {
        return planId;
    }
    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    //vehicleId
    public String getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    //totalLoad
    public Double getTotalLoad() {
        return totalLoad;
    }
    public void setTotalLoad(Double totalLoad) {
        this.totalLoad = totalLoad;
    }

    //totalDistance
    public Double getTotalDistance() {
        return totalDistance;
    }
    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public List<Order> getAssignedOrders() {
        return assignedOrders;
    }
    public void setAssignedOrders(List<Order> assignedOrders){
        this.assignedOrders = assignedOrders;
    }


}
