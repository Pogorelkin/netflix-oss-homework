package com.epam.hw.netflix.dao.impl;

import com.epam.hw.netflix.dao.OrdersDAO;
import com.epam.hw.netflix.domain.Order;
import com.epam.hw.netflix.domain.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersDAOImpl implements OrdersDAO {
    @Autowired
    private MongoTemplate mongoTemplate;
    private static final String collectionName = "orders";

    @Override
    public void create(Order order) {
        mongoTemplate.insert(order, collectionName);
    }

    @Override
    public List<Order> findAll() {
        return mongoTemplate.findAll(Order.class, collectionName);
    }

    @Override
    public Order findById(String s) {
        return mongoTemplate.findById(s, Order.class, collectionName);
    }

    @Override
    public void update(Order order) {
        mongoTemplate.updateFirst(new Query().addCriteria((Criteria.where("id").is(order.getId()))),
                new Update(),
                Workspace.class, collectionName);
    }

    @Override
    public void delete(Order order) {
        mongoTemplate.remove(order, collectionName);
    }

    @Override
    public void deleteCollection() {
        mongoTemplate.dropCollection(collectionName);
    }
}
