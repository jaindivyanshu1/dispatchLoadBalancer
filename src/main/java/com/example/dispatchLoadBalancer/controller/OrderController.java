package com.example.dispatchLoadBalancer.controller;

import com.example.dispatchLoadBalancer.dto.OrderDTO;
import com.example.dispatchLoadBalancer.exception.InvalidOrderException;
import com.example.dispatchLoadBalancer.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/dispatchLoadBalance/orders")
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrders(@RequestBody @Valid List<@Valid OrderDTO> orders) {
        if (orders.isEmpty()) {
            throw new InvalidOrderException("Order list cannot be empty");
        }
        orderService.saveOrders(orders);
        return ResponseEntity.ok().body(
                new ApiResponse("Delivery orders accepted", "success")
        );
    }

}
