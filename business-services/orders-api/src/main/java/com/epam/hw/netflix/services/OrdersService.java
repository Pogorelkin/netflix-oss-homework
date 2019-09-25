package com.epam.hw.netflix.services;

import com.epam.hw.netflix.dao.OrdersDAO;
import com.epam.hw.netflix.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import static com.google.common.collect.Lists.newArrayList;
import java.util.List;

@Slf4j
@Service
public class OrdersService {
    @Autowired
    OrdersDAO ordersDAO;

    private final List<Order> orders =  newArrayList(
            new Order("0000001", "0000001", "0000001"),
            new Order("0000002", "0000002", "0000002"),
            new Order("0000003", "0000003", "0000003"),
            new Order("0000004", "0000004", "0000004")
    );

    public List<Order> findAll() {
        return ordersDAO.findAll();
    }

    public Order findOrderById(String id) {
        return ordersDAO.findById(id);
    }

    @PostConstruct
    private void init() {
        System.out.println("init orders");
        ordersDAO.deleteCollection();
        orders.forEach(e -> ordersDAO.create(e));
    }
}
