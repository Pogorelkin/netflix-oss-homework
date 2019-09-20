package com.epam.hw.netflix.dao.impl;

import com.epam.hw.netflix.dao.EmployeesDAO;
import com.epam.hw.netflix.domain.Employee;
import com.epam.hw.netflix.domain.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Repository
public class EmployeesDAOImpl implements EmployeesDAO {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void create(Employee employee) {
        mongoTemplate.insert(employee, "employees");
    }

    @Override
    public List<Employee> findAll() {
        return mongoTemplate.findAll(Employee.class, "employees");
    }

    @Override
    public Employee findById(String s) {
        return mongoTemplate.findById(s, Employee.class, "employees");
    }

    @Override
    public void update(Employee employee) {
        mongoTemplate.updateFirst(new Query().addCriteria((Criteria.where("id").is(employee.getId()))),
                new Update(),
                Workspace.class,
                "employees");
    }

    @Override
    public void delete(Employee employee) {
        mongoTemplate.remove(employee, "employees");
    }

    @Override
    public void deleteCollection(String collection) {
        mongoTemplate.dropCollection(collection);
    }

    public Employee findByIdAndName(String id, String name) {
        return mongoTemplate.findOne(new Query().addCriteria((Criteria.where("id").is(id).and("firstName").is(name))),
                Employee.class, "employees");
    }

    public Employee findWithMaxId() {
        final Query query = new Query().limit(1).with(new Sort(Sort.DEFAULT_DIRECTION, "id"));
        return mongoTemplate.findOne(query, Employee.class, "employees");
    }

    public String findAvgId() {
        Aggregation aggregation = newAggregation(group("id").avg("id").as("avgId"));
        AggregationResults<String> results = mongoTemplate.aggregate(aggregation, "employees", String.class);
        return results.getUniqueMappedResult();
    }

    public void updIfId(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update().set("lastName", "Huh");
        mongoTemplate.updateFirst(query, update, Employee.class, "employees");
    }
}
