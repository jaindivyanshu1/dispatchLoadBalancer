package com.example.dispatchLoadBalancer.controller;

import com.example.dispatchLoadBalancer.dto.VehicleDTO;
import com.example.dispatchLoadBalancer.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dispatchLoadBalancer/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody List<VehicleDTO> vehicles) {
        vehicleService.saveVehicles(vehicles);
        return ResponseEntity.ok().body(
                new ApiResponse("Vehicle details accepted", "success")
        );
    }

}
