package com.epam.hw.netflix.dao;

import com.epam.hw.netflix.domain.Employee;

import java.util.List;

public interface EmployeesDAO {
    void create(Employee employee);

    List<Employee> findAll();

    Employee findById(String s);

    void update(Employee employee);

    void delete(Employee employee);

    void deleteCollection(String collection);
}
