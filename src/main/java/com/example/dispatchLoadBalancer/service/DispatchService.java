package com.example.dispatchLoadBalancer.service;

import com.example.dispatchLoadBalancer.dto.DispatchPlanDTO;

import java.util.List;

public interface DispatchService {
    List<DispatchPlanDTO> generateDispatchPlan();
}
