package com.example.order.controller;


import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) throws JsonProcessingException {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/status")
    public List<Object[]> getTotalAmountAndStatus() {
        return orderService.findTotalAmountAndStatus();
    }

    @GetMapping("/status/response")
    public ResponseEntity<List<Object[]>> getTotalAmoundAndStatusAndResponse(){
        return ResponseEntity.ok(orderService.findTotalAmountAndStatus());
    }

}
