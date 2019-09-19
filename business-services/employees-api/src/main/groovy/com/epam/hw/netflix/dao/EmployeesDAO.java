package com.epam.hw.netflix.dao;

import com.epam.hw.netflix.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeesDAO extends MongoRepository<Employee, String> {

}
