package com.epam.hw.netflix.dao;

import com.epam.hw.netflix.domain.Order;

import java.util.List;

public interface OrdersDAO {
    void create(Order order);

    List<Order> findAll();

    Order findById(String s);

    void update(Order order);

    void delete(Order order);

    void deleteCollection();
}
