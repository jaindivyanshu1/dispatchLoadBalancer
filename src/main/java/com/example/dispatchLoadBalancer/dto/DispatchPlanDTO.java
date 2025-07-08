package com.example.dispatchLoadBalancer.dto;

import java.util.List;

public class DispatchPlanDTO {

    private Long planId;

    private String vehicleId;
    private Double totalLoad;
    private Double totalDistance;
    private List<OrderDTO> assignedOrders;

    public DispatchPlanDTO(){}

    public DispatchPlanDTO(
            Long planId,
            String vehicleId,
            Double totalDistance,
            Double totalLoad,
            List<OrderDTO> assignedOrders
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

    public List<OrderDTO> getAssignedOrders() {
        return assignedOrders;
    }
    public void setAssignedOrders(List<OrderDTO> assignedOrders){
        this.assignedOrders = assignedOrders;
    }



}
