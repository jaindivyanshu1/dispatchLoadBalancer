package com.example.dispatchLoadBalancer.service.impl;

import com.example.dispatchLoadBalancer.dto.OrderDTO;
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
        List<Order> orderEntities = orders.stream().map(dto -> {
            return new Order(
                    dto.getOrderId(),
                    dto.getLatitude(),
                    dto.getLongitude(),
                    dto.getAddress(),
                    dto.getPackageWeight(),
                    Order.Priority.valueOf(dto.getPriority().toUpperCase())
            );
        }).toList();
        orderRepository.saveAll(orderEntities);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
