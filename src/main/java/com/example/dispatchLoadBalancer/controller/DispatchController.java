package com.example.dispatchLoadBalancer.controller;

import com.example.dispatchLoadBalancer.dto.DispatchPlanDTO;
import com.example.dispatchLoadBalancer.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dispatch/plan")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;

    @GetMapping
    public ResponseEntity<List<DispatchPlanDTO>> getDispatchPlan() {
        List<DispatchPlanDTO> plan = dispatchService.generateDispatchPlan();
        return ResponseEntity.ok().body(plan);
    }

}
