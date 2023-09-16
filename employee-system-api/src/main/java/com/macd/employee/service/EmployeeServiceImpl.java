package com.macd.employee.service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import com.macd.employee.entity.EmployeeEntity;
import com.macd.employee.entity.MaxFieldEntity;
import com.macd.employee.model.Employee;
import com.macd.employee.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final MongoOperations mongoOperations;
  private final MongoTemplate mongoTemplate;

  private AtomicLong empId = new AtomicLong();

  public EmployeeServiceImpl(
      EmployeeRepository employeeRepository,
      MongoOperations mongoOperations,
      MongoTemplate mongoTemplate) {
    this.employeeRepository = employeeRepository;
    this.mongoOperations = mongoOperations;
    this.mongoTemplate = mongoTemplate;
  }

  @PostConstruct
  private void getEmpId() {
    GroupOperation groupOperation = group().max("empId").as("maxField");
    Aggregation aggregation = newAggregation(groupOperation);

    AggregationResults<MaxFieldEntity> results =
        mongoOperations.aggregate(aggregation, EmployeeEntity.class, MaxFieldEntity.class);
    Optional<Long> optionalId =
        Optional.ofNullable(
            results.getMappedResults().isEmpty()
                ? null
                : results.getUniqueMappedResult().getMaxField());
    Long eId = optionalId.map(id -> id + 1).orElse(1L);
    empId.set(eId);
  }

  @Override
  public Employee createEmployee(Employee employee) {
    EmployeeEntity employeeEntity = new EmployeeEntity();

    BeanUtils.copyProperties(employee, employeeEntity);
    employeeEntity.setEmpId(empId.incrementAndGet());
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

  @Override
  public boolean deleteEmployee(Long id) {
    boolean deleteFlag = false;
    Query query = new Query();
    query.addCriteria(Criteria.where("empId").is(id));
    List<EmployeeEntity> employees = mongoTemplate.find(query, EmployeeEntity.class);
    deleteFlag = !employees.isEmpty();
    employees.forEach(employeeRepository::delete);
    return deleteFlag;
  }
}
