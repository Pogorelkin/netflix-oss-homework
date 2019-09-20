package com.epam.hw.netflix.dao.impl;

import com.epam.hw.netflix.dao.EmployeesDAO;
import com.epam.hw.netflix.domain.Employee;
import com.epam.hw.netflix.domain.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
