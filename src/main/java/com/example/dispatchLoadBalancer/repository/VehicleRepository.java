package com.example.dispatchLoadBalancer.repository;

import com.example.dispatchLoadBalancer.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
