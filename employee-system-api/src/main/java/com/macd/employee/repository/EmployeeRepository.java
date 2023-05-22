package com.macd.employee.repository;

import com.macd.employee.entity.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {
}
