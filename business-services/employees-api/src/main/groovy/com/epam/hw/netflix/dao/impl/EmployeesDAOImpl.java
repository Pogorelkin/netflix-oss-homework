package com.epam.hw.netflix.dao.impl;

import com.epam.hw.netflix.dao.EmployeesDAO;
import com.epam.hw.netflix.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Optional;

public class EmployeesDAOImpl implements EmployeesDAO {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public <S extends Employee> S save(S entity) {
        return mongoTemplate.insert(entity, "employees");
    }

    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Employee> findById(String s) {
        return Optional.of(mongoTemplate.findById(s, Employee.class));
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Employee> findAll() {
        return mongoTemplate.findAll(Employee.class, "employees");
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Employee entity) {
        mongoTemplate.remove(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {
        mongoTemplate.dropCollection("employees");
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employee> S insert(S entity) {
        return mongoTemplate.insert(entity);
    }

    @Override
    public <S extends Employee> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Employee> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employee> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Employee> boolean exists(Example<S> example) {
        return false;
    }
}
