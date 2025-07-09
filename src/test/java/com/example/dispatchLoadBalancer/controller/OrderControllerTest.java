package com.example.dispatchLoadBalancer.controller;

import com.example.dispatchLoadBalancer.dto.OrderDTO;
import com.example.dispatchLoadBalancer.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldAcceptValidOrders() throws Exception {
        List<OrderDTO> orders = List.of(
                new OrderDTO("ORD001", 12.9716, 77.5946, "MG Road", 10.0, "HIGH")
        );

        mockMvc.perform(post("/api/dispatchLoadBalance/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orders)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Delivery orders accepted"))
                .andExpect(jsonPath("$.status").value("success"));
    }

    @Test
    void shouldRejectOrderWithMissingFields() throws Exception {
        String payload = """
                [{
                    "latitude": 12.9716,
                    "longitude": 77.5946,
                    "address": "MG Road",
                    "packageWeight": 10.0,
                    "priority": "HIGH"
                }]
                """;

        mockMvc.perform(post("/api/dispatchLoadBalance/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldRejectEmptyOrderList() throws Exception {
        mockMvc.perform(post("/api/dispatchLoadBalance/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[]"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Order list cannot be empty"));
    }

    @Test
    void shouldRejectInvalidWeight() throws Exception {
        String payload = """
                [{
                    "orderId": "ORD001",
                    "latitude": 12.9716,
                    "longitude": 77.5946,
                    "address": "MG Road",
                    "packageWeight": -5.0,
                    "priority": "HIGH"
                }]
                """;

        mockMvc.perform(post("/api/dispatchLoadBalance/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isBadRequest());
    }
}
