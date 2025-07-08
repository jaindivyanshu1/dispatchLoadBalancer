package com.example.dispatchLoadBalancer.service.impl;

import com.example.dispatchLoadBalancer.dto.DispatchPlanDTO;
import com.example.dispatchLoadBalancer.repository.OrderRepository;
import com.example.dispatchLoadBalancer.repository.VehicleRepository;
import com.example.dispatchLoadBalancer.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispatchServiceImpl implements DispatchService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<DispatchPlanDTO> generateDispatchPlan() {
        return new ArrayList<>();
    }
}
