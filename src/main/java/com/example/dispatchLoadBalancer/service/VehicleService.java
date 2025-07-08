package com.example.dispatchLoadBalancer.service;

import com.example.dispatchLoadBalancer.dto.VehicleDTO;
import com.example.dispatchLoadBalancer.model.Vehicle;

import java.util.List;

public interface VehicleService {
    void saveVehicles(List<VehicleDTO> vehicles);
    List<Vehicle> getAllVehicles();
}
