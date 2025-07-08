package com.example.dispatchLoadBalancer.repository;

import com.example.dispatchLoadBalancer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
