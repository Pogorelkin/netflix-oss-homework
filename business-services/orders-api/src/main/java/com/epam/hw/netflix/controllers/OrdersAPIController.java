package com.epam.hw.netflix.controllers;

import com.epam.hw.netflix.domain.Order;
import com.epam.hw.netflix.services.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/orders")
@Slf4j
public class OrdersAPIController {
    @Autowired
    OrdersService ordersService;

    @RequestMapping("/{id}")
    public Order getOrderById(@PathVariable("id") String id) {
        log.info("Instance {} received order request", this);
        return ordersService.findOrderById(id);
    }

    @RequestMapping("/all")
    public List<Order> getAllOrders() {
        log.info("Instance {} received all orders request", this);
        return ordersService.findAll();
    }
}
