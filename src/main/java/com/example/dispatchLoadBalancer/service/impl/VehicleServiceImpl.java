package com.example.dispatchLoadBalancer.service.impl;

import com.example.dispatchLoadBalancer.dto.VehicleDTO;
import com.example.dispatchLoadBalancer.model.Vehicle;
import com.example.dispatchLoadBalancer.repository.VehicleRepository;
import com.example.dispatchLoadBalancer.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void saveVehicles(List<VehicleDTO> vehicles) {
        List<Vehicle> vehiclesEntities = vehicles.stream().map(dto -> {
            return new Vehicle(
                    dto.getVehicleId(),
                    dto.getCapacity(),
                    dto.getCurrentLatitude(),
                    dto.getCurrentLongitude(),
                    dto.getCurrentAddress()
            );
        }).toList();
        vehicleRepository.saveAll(vehiclesEntities);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}
