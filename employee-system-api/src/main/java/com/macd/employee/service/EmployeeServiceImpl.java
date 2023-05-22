package com.macd.employee.service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import com.macd.employee.entity.EmployeeEntity;
import com.macd.employee.entity.MaxFieldEntity;
import com.macd.employee.model.Employee;
import com.macd.employee.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final MongoOperations mongoOperations;

  private Long empId;

  public EmployeeServiceImpl(
      EmployeeRepository employeeRepository, MongoOperations mongoOperations) {
    this.employeeRepository = employeeRepository;
    this.mongoOperations = mongoOperations;
  }

  @PostConstruct
  private void getEmpId() {
    GroupOperation groupOperation = group().max("empId").as("maxField");
    Aggregation aggregation = newAggregation(groupOperation);

    AggregationResults<MaxFieldEntity> results =
        mongoOperations.aggregate(aggregation, EmployeeEntity.class, MaxFieldEntity.class);
    Long id =
        results.getMappedResults().size() == 0
            ? null
            : results.getUniqueMappedResult().getMaxField();
    empId = id == null ? 1L : id;
  }

  @Override
  public Employee createEmployee(Employee employee) {
    EmployeeEntity employeeEntity = new EmployeeEntity();

    BeanUtils.copyProperties(employee, employeeEntity);
    employeeEntity.setEmpId(empId++);
    employeeRepository.save(employeeEntity);
    return employee;
  }

  @Override
  public List<Employee> getAllEmployees() {
    List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
    return employeeEntities.stream()
        .map(
            emp ->
                new Employee(
                    emp.getEmpId(), emp.getFirstName(), emp.getLastName(), emp.getEmailId()))
        .collect(Collectors.toList());
  }
}
