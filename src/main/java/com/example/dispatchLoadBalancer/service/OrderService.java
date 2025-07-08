package com.example.dispatchLoadBalancer.service;

import com.example.dispatchLoadBalancer.dto.OrderDTO;
import com.example.dispatchLoadBalancer.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrders(List<OrderDTO> orders);
    List<Order> getAllOrders();
}
