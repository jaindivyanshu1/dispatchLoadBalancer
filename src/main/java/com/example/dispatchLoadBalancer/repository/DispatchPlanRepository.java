package com.example.dispatchLoadBalancer.repository;

import com.example.dispatchLoadBalancer.model.DispatchPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchPlanRepository extends JpaRepository<DispatchPlan, Long> {
}
