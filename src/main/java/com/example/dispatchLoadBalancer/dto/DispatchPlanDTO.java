package com.example.dispatchLoadBalancer.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public class DispatchPlanDTO {

    @NotBlank(message = "Vehicle ID is required")
    private String vehicleId;

    @NotNull(message = "Total load is required")
    @PositiveOrZero(message = "Total load must be 0 or more")
    private Double totalLoad;

    @NotBlank(message = "Total distance is required")
    private Double totalDistance;

    @NotNull(message = "Assigned orders list is required")
    @Size(min = 1, message = "At least one assigned order is required")
    private List<@Valid OrderDTO> assignedOrders;

    public DispatchPlanDTO(){}

    public DispatchPlanDTO(
            String vehicleId,
            Double totalDistance,
            Double totalLoad,
            List<OrderDTO> assignedOrders
    ) {
        this.vehicleId = vehicleId;
        this.totalDistance = totalDistance;
        this.totalLoad = totalLoad;
        this.assignedOrders = assignedOrders;
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
