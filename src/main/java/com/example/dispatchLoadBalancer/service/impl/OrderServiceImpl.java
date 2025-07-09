package com.example.dispatchLoadBalancer.service.impl;

import com.example.dispatchLoadBalancer.dto.OrderDTO;
import com.example.dispatchLoadBalancer.exception.InvalidOrderException;
import com.example.dispatchLoadBalancer.model.Order;
import com.example.dispatchLoadBalancer.repository.OrderRepository;
import com.example.dispatchLoadBalancer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void saveOrders(List<OrderDTO> orders) {
        if (orders == null || orders.isEmpty()) {
            throw new InvalidOrderException("Order list cannot be null or empty");
        }

        List<Order> orderEntities = orders.stream().map(dto -> {
            if (dto.getOrderId() == null || dto.getOrderId().isBlank()) {
                throw new InvalidOrderException("Order ID is missing");
            }

            if (dto.getLatitude() == null || dto.getLongitude() == null) {
                throw new InvalidOrderException("Latitude or Longitude cannot be null");
            }

            if (dto.getPriority() == null || dto.getPriority().isBlank()) {
                throw new InvalidOrderException("Order priority must be provided");
            }

            if (dto.getPackageWeight() == null || dto.getPackageWeight() <= 0) {
                throw new InvalidOrderException("Package weight must be greater than 0");
            }

            Order.Priority priority;
            try {
                priority = Order.Priority.valueOf(dto.getPriority().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new InvalidOrderException("Invalid priority: " + dto.getPriority());
            }

            return new Order(
                    dto.getOrderId(),
                    dto.getLatitude(),
                    dto.getLongitude(),
                    dto.getAddress(),
                    dto.getPackageWeight(),
                    priority
            );
        }).toList();

        orderRepository.saveAll(orderEntities);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
